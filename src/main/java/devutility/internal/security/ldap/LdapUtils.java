package devutility.internal.security.ldap;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LdapUtils {
	/**
	 * Url format of provider
	 */
	public static final String PROVIDER_URLFORMAT = "LDAP://%s";

	/**
	 * Get provider url.
	 * @param host: Host address
	 * @return String: Provider url
	 */
	public static String providerUrl(String host) {
		return String.format(PROVIDER_URLFORMAT, host);
	}

	/**
	 * Connect with provider url
	 * @param loginName: Login name for provider url
	 * @param password: Password for provider url
	 * @param providerUrl: Provider url
	 * @return LdapContext
	 * @throws NamingException
	 */
	public static LdapContext connect(String loginName, String password, String providerUrl) throws NamingException {
		Hashtable<String, String> hashtable = new Hashtable<>();
		hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		hashtable.put(Context.SECURITY_AUTHENTICATION, "simple");
		hashtable.put(Context.SECURITY_PRINCIPAL, loginName);
		hashtable.put(Context.SECURITY_CREDENTIALS, password);
		hashtable.put(Context.PROVIDER_URL, providerUrl);
		return new InitialLdapContext(hashtable, null);
	}

	/**
	 * Login
	 * @param loginName: loginName@xxx.com or logiName.
	 * @param password: Password for login
	 * @param host: Example xxx.com
	 * @return boolean
	 */
	public static boolean login(String loginName, String password, String host) {
		String name = loginName(loginName, host);
		String providerUrl = providerUrl(host);
		return verify(name, password, providerUrl);
	}

	/**
	 * Check the format of login name and return.
	 * @param loginName: loginName@xxx.com or logiName.
	 * @param host: Example xxx.com
	 * @return String
	 */
	private static String loginName(String loginName, String host) {
		String name = loginName;

		if (loginName.indexOf(host) == -1) {
			name = String.format("%s@%s", loginName, host);
		}

		return name;
	}

	/**
	 * Verify
	 * @param loginName: Login name for provider Url
	 * @param password: Password
	 * @param providerUrl: Provider Url
	 * @return boolean
	 */
	public static boolean verify(String loginName, String password, String providerUrl) {
		LdapContext context = null;

		try {
			context = connect(loginName, password, providerUrl);
			return true;
		} catch (NamingException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (context != null) {
				try {
					context.close();
				} catch (NamingException e) {
				}
			}
		}
	}

	/**
	 * Get ldap account information.
	 * @param loginName: loginName@xxx.com or logiName.
	 * @param password: Password for login.
	 * @param host: Example xxx.com.
	 * @return LdapAccount
	 */
	public static LdapAccount getLdapAccount(String loginName, String password, String host) {
		loginName = loginName(loginName, host);
		String providerUrl = providerUrl(host);
		LdapContext ldapContext = null;

		try {
			ldapContext = connect(loginName, password, providerUrl);
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
	public static java.util.List<LdapAccount> search(LdapContext ldapContext, String searchBase, String searchFilter, SearchControls searchControls) throws NamingException {
		java.util.List<LdapAccount> list = new LinkedList<>();
		NamingEnumeration<SearchResult> namingEnumerationLevel1 = ldapContext.search(searchBase, searchFilter, searchControls);

		while (namingEnumerationLevel1.hasMoreElements()) {
			LdapAccount ldapAccount = new LdapAccount();
			SearchResult searchResult = namingEnumerationLevel1.nextElement();
			ldapAccount.put("name", Arrays.asList(searchResult.getName()));

			Attributes attributes = searchResult.getAttributes();
			NamingEnumeration<?> namingEnumerationLevel2 = attributes.getAll();

			while (namingEnumerationLevel2.hasMore()) {
				Attribute attribute = (Attribute) namingEnumerationLevel2.next();
				ldapAccount.put(attribute.getID().toString(), getAttributeValue(attribute));
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