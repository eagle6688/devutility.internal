package devutility.internal.ldap;

import java.util.Hashtable;

import javax.naming.Context;

import devutility.internal.security.DUSocketFactory;

/**
 * 
 * LdapContextEnvironmentFactory
 * 
 * @author: Aldwin Su
 * @version: 2020-04-24 14:21:45
 */
public class LdapContextEnvironmentFactory {
	/**
	 * LdapProperties object.
	 */
	private LdapProperties ldapProperties;

	/**
	 * Constructor
	 * @param ldapProperties LdapProperties object.
	 */
	public LdapContextEnvironmentFactory(LdapProperties ldapProperties) {
		this.ldapProperties = ldapProperties;
	}

	/**
	 * Create a Hashtable object as environment for LdapContext object.
	 * @return Hashtable<String,String>
	 */
	public Hashtable<String, String> create() {
		Hashtable<String, String> environment = new Hashtable<>();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.PROVIDER_URL, ldapProperties.getUrl());

		if (ldapProperties.getUrl().startsWith("ldaps") && !ldapProperties.isValidateCert()) {
			environment.put("java.naming.ldap.factory.socket", DUSocketFactory.class.getName());
		}

		return environment;
	}

	/**
	 * Create a Hashtable object as environment for LdapContext object.
	 * @param principal Principal in LDAP system, sometimes its a login name.
	 * @param credentials Password for specific entry in LDAP.
	 * @return Hashtable<String,String>
	 */
	public Hashtable<String, String> create(String principal, String credentials) {
		Hashtable<String, String> environment = create();
		environment.put(Context.SECURITY_PRINCIPAL, principal);
		environment.put(Context.SECURITY_CREDENTIALS, credentials);
		return environment;
	}
}