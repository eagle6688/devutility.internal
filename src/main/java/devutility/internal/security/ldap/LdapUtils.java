package devutility.internal.security.ldap;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 * 
 * LdapUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-04-19 14:27:12
 */
public class LdapUtils {
	/**
	 * Ldap provider url format.
	 */
	private final static String PROVIDERURL_LDAP_FORMAT = "ldap://%s";

	/**
	 * Ldaps provider url format.
	 */
	private final static String PROVIDERURL_LDAPS_FORMAT = "ldaps://%s";

	/**
	 * Ldap default port.
	 */
	public final static int PORT = 389;

	/**
	 * Get provider url of ldap.
	 * @param host Host address without ldap:// prefix.
	 * @return String
	 */
	public static String ldapProviderUrl(String host) {
		return String.format(PROVIDERURL_LDAP_FORMAT, host);
	}

	/**
	 * Get provider url of ldaps.
	 * @param host Host address without ldaps:// prefix.
	 * @return String
	 */
	public static String ldapsProviderUrl(String host) {
		return String.format(PROVIDERURL_LDAPS_FORMAT, host);
	}

	/**
	 * Initializing a LdapContext instance.
	 * @param providerUrl Provider url for LDAP with format ldap://host:port.
	 * @param principal Principal in LDAP system, sometimes its a login name.
	 * @param credentials Password for specific entry in LDAP.
	 * @return LdapContext
	 * @throws NamingException
	 */
	public static LdapContext ldapContext(String providerUrl, String principal, String credentials) throws NamingException {
		Hashtable<String, String> environment = new Hashtable<>();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.PROVIDER_URL, providerUrl);
		environment.put(Context.SECURITY_PRINCIPAL, principal);
		environment.put(Context.SECURITY_CREDENTIALS, credentials);
		return new InitialLdapContext(environment, null);
	}

	/**
	 * Authenticate principal and password matched in providerUrl or not?
	 * @param providerUrl Provider url for LDAP with format ldap://host:port.
	 * @param principal Principal in LDAP system, sometimes its a login name.
	 * @param password Password for specific entry in LDAP.
	 * @return boolean
	 */
	public static boolean authenticate(String providerUrl, String principal, String password) {
		LdapContext context = null;

		try {
			context = ldapContext(providerUrl, principal, password);
			return true;
		} catch (NamingException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (context != null) {
				try {
					context.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static LdapEntry search(String providerUrl, String principal, String password, SearchControls searchControls) {
		return null;
	}

	public static List<LdapEntry> toLdapEntries(NamingEnumeration<SearchResult> namingEnumeration) throws NamingException {
		List<LdapEntry> list = new LinkedList<>();

		if (namingEnumeration == null || !namingEnumeration.hasMoreElements()) {
			return list;
		}

		while (namingEnumeration.hasMoreElements()) {
			SearchResult searchResult = namingEnumeration.nextElement();
			LdapEntry entry = new LdapEntry(searchResult.getName());
			NamingEnumeration<?> attributes = searchResult.getAttributes().getAll();

			while (attributes.hasMore()) {
				Attribute attribute = (Attribute) attributes.next();
				entry.put(attribute.getID().toString(), getAttributeValue(attribute));
			}

			list.add(entry);
		}

		return list;
	}

	/**
	 * Get ldap account information.
	 * @param loginName loginName@xxx.com or logiName.
	 * @param password Password for login.
	 * @param host Example xxx.com.
	 * @return LdapEntry
	 */
	public static LdapEntry getLdapAccount(String loginName, String password, String host) {
		String providerUrl = ldapProviderUrl(host);
		LdapContext ldapContext = null;

		try {
			ldapContext = ldapContext(providerUrl, loginName, password);
			SearchControls searchControls = new SearchControls();
			searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			searchControls.setReturningAttributes(null);
			return search(ldapContext, getDomainComponent(host), getSearchFilter(loginName), searchControls).get(0);
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (ldapContext != null) {
				try {
					ldapContext.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Search
	 * @param ldapContext: LdapContext object.
	 * @param searchBase: SearchBase.
	 * @param searchFilter: SearchFilter.
	 * @param searchControls: SearchControls object
	 * @return {@code List<LdapAccount>}
	 * @throws NamingException
	 */
	public static java.util.List<LdapEntry> search(LdapContext ldapContext, String searchBase, String searchFilter, SearchControls searchControls) throws NamingException {
		java.util.List<LdapEntry> list = new LinkedList<>();
		NamingEnumeration<SearchResult> namingEnumerationLevel1 = ldapContext.search(searchBase, searchFilter, searchControls);

		while (namingEnumerationLevel1.hasMoreElements()) {
			LdapEntry ldapAccount = new LdapEntry();
			SearchResult searchResult = namingEnumerationLevel1.nextElement();
			ldapAccount.put("name", Arrays.asList(searchResult.getName()));

			Attributes attributes = searchResult.getAttributes();
			NamingEnumeration<?> namingEnumerationLevel2 = attributes.getAll();

			while (namingEnumerationLevel2.hasMore()) {
				Attribute attribute = (Attribute) namingEnumerationLevel2.next();
				ldapAccount.put(attribute.getID().toString(), getAttributeValue(attribute));
				System.out.println(attribute.getID().toString() + ":" + getAttributeValue(attribute));
			}

			list.add(ldapAccount);
		}

		return list;
	}

	/**
	 * Get domain component from host.
	 * @param host: Example xxx.com.
	 * @return String
	 */
	private static String getDomainComponent(String host) {
		int index = host.lastIndexOf(".");

		if (index == -1) {
			throw new IllegalArgumentException("Invalid format of host!");
		}

		return String.format("DC=%s,DC=%s", host.substring(0, index), host.substring(index + 1));
	}

	/**
	 * Get search filter by login name.
	 * @param loginName: Should contain host.
	 * @return String
	 */
	private static String getSearchFilter(String loginName) {
		int index = loginName.indexOf("@");

		if (index == -1) {
			throw new IllegalArgumentException("LoginName should contain host like \"@xxx.com\"");
		}

		return String.format("sAMAccountName=%s", loginName.substring(0, index));
	}

	/**
	 * Get attribute value.
	 * @param attribute: Attribute object.
	 * @return java.util.List<String>
	 * @throws NamingException
	 */
	private static java.util.List<String> getAttributeValue(Attribute attribute) throws NamingException {
		java.util.List<String> list = new LinkedList<>();
		NamingEnumeration<?> namingEnumeration = attribute.getAll();

		while (namingEnumeration.hasMore()) {
			list.add(namingEnumeration.next().toString());
		}

		return list;
	}
}