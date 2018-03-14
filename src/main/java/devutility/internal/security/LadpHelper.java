package devutility.internal.security;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LadpHelper {
	/**
	 * Url format of provider
	 */
	public static final String PROVIDER_URLFORMAT = "LDAP://%s";

	/**
	 * providerUrl 
	 * @param host
	 * @return String
	 */
	public static String providerUrl(String host) {
		return String.format(PROVIDER_URLFORMAT, host);
	}

	/**
	 * connect 
	 * @throws NamingException LdapContext
	 */
	public static LdapContext connect(String loginName, String password, String providerUrl) throws NamingException {
		Hashtable<String, String> hashtable = new Hashtable<>();
		hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		hashtable.put(Context.SECURITY_AUTHENTICATION, "simple");
		hashtable.put(Context.SECURITY_PRINCIPAL, loginName);
		hashtable.put(Context.SECURITY_CREDENTIALS, password);
		hashtable.put(Context.PROVIDER_URL, providerUrl);

		LdapContext context = new InitialLdapContext(hashtable, null);
		return context;
	}

	/**
	 * login 
	 * @param loginName loginName@xxx.com or logiNname
	 * @param password
	 * @param host xxx.com
	 * @return boolean
	 */
	public static boolean login(String loginName, String password, String host) {
		String name = loginName;

		if (loginName.indexOf(host) == -1) {
			name = String.format("%s@%s", loginName, host);
		}

		String providerUrl = providerUrl(host);
		return verify(name, password, providerUrl);
	}

	/**
	 * verify 
	 * @param loginName login name
	 * @param password password
	 * @param providerUrl provider Url
	 * @return boolean
	 */
	public static boolean verify(String loginName, String password, String providerUrl) {
		LdapContext context = null;

		try {
			context = connect(loginName, password, providerUrl);
			return true;
		} catch (NamingException e) {
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
}