package devutility.internal.security.ldap;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
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
	 * Get domain component.
	 * @param domain Domain name.
	 * @return String
	 */
	public static String getDomainComponent(String domain) {
		int index = domain.lastIndexOf(".");

		if (index == -1) {
			throw new IllegalArgumentException("Invalid format of host!");
		}

		return String.format("DC=%s,DC=%s", domain.substring(0, index), domain.substring(index + 1));
	}

	/**
	 * Get search filter for active directory.
	 * @param accountName sAMAccountName value.
	 * @return String
	 */
	public static String getActiveDirectoryFilter(String accountName) {
		return String.format("sAMAccountName=%s", accountName);
	}

	/**
	 * Get attribute value.
	 * @param attribute Attribute object.
	 * @return {@code List<String>}
	 * @throws NamingException From NamingEnumeration.
	 */
	public static List<String> getAttributeValue(Attribute attribute) throws NamingException {
		List<String> list = new LinkedList<>();
		NamingEnumeration<?> namingEnumeration = attribute.getAll();

		while (namingEnumeration.hasMore()) {
			list.add(namingEnumeration.next().toString());
		}

		return list;
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

	/**
	 * Search LdapEntry objects in Ldap system.
	 * @param providerUrl Provider url for LDAP with format ldap://host:port.
	 * @param principal Principal in LDAP system, sometimes its a login name.
	 * @param password Password for specific entry in LDAP.
	 * @param name The name of the context or object to search.
	 * @param filter The filter expression to use for the search; may not be null.
	 * @param searchControls SearchControls object.
	 * @return {@code List<LdapEntry>}
	 * @throws NamingException
	 */
	public static List<LdapEntry> search(String providerUrl, String principal, String password, String name, String filter, SearchControls searchControls) throws NamingException {
		LdapContext context = ldapContext(providerUrl, principal, password);
		return search(context, name, filter, searchControls);
	}

	/**
	 * Search LdapEntry objects in Ldap system.
	 * @param ldapContext LdapContext object.
	 * @param name The name of the context or object to search.
	 * @param filter The filter expression to use for the search; may not be null.
	 * @param searchControls SearchControls object.
	 * @return {@code List<LdapAccount>}
	 * @throws NamingException
	 */
	public static List<LdapEntry> search(LdapContext ldapContext, String name, String filter, SearchControls searchControls) throws NamingException {
		NamingEnumeration<SearchResult> searchResult = ldapContext.search(name, filter, searchControls);
		return toLdapEntries(searchResult);
	}

	/**
	 * Search LdapEntry objects in Ldap system.
	 * @param ldapContext LdapContext object.
	 * @param name The name of the context or object to search.
	 * @param filter The filter expression to use for the search; may not be null.
	 * @return {@code List<LdapEntry>}
	 * @throws NamingException From search and toLdapEntries.
	 */
	public static List<LdapEntry> search(LdapContext ldapContext, String name, String filter) throws NamingException {
		SearchControls searchControls = new SearchControls();
		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		searchControls.setReturningAttributes(null);
		return search(ldapContext, name, filter, searchControls);
	}

	/**
	 * Convert NamingEnumeration to LdapEntry list.
	 * @param namingEnumeration NamingEnumeration object.
	 * @return {@code List<LdapEntry>}
	 * @throws NamingException From NamingEnumeration object..
	 */
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
}