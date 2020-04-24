package devutility.internal.ldap;

import java.util.Hashtable;

import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 * 
 * LdapContextFactory
 * 
 * @author: Aldwin Su
 * @version: 2020-04-24 14:33:05
 */
public class LdapContextFactory {
	/**
	 * LdapContextEnvironmentFactory object.
	 */
	private LdapContextEnvironmentFactory ldapContextEnvironmentFactory;

	/**
	 * Constructor
	 * @param ldapProperties LdapProperties object.
	 */
	public LdapContextFactory(LdapProperties ldapProperties) {
		this.ldapContextEnvironmentFactory = new LdapContextEnvironmentFactory(ldapProperties);
	}

	/**
	 * Initializing a LdapContext instance.
	 * @param principal Principal in LDAP system, sometimes its a login name.
	 * @param credentials Password for specific entry in LDAP.
	 * @return LdapContext
	 * @throws NamingException
	 */
	public LdapContext create(String principal, String credentials) throws NamingException {
		Hashtable<String, String> environment = ldapContextEnvironmentFactory.create(principal, credentials);
		return new InitialLdapContext(environment, null);
	}
}