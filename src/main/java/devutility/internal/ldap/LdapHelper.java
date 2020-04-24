package devutility.internal.ldap;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.ldap.LdapContext;

import devutility.internal.util.CollectionUtils;

/**
 * 
 * LdapHelper
 * 
 * @author: Aldwin Su
 * @version: 2019-04-19 15:29:19
 */
public class LdapHelper {
	/**
	 * Ldap configuration
	 */
	private LdapProperties ldapProperties;

	/**
	 * LdapContextFactory object for creating LdapContext.
	 */
	private LdapContextFactory ldapContextFactory;

	/**
	 * Constructor
	 */
	public LdapHelper() {
	}

	/**
	 * Constructor
	 * @param ldapProperties LdapProperties object.
	 */
	public LdapHelper(LdapProperties ldapProperties) {
		this.ldapProperties = ldapProperties;
		this.ldapContextFactory = new LdapContextFactory(ldapProperties);
	}

	/**
	 * Search data in LDAP.
	 * @param principal Principal in LDAP system, sometimes its a login name.
	 * @param password Password for specific entry in LDAP.
	 * @param filter Filter expression such as {{field name}}={{value}}
	 * @param searchControls SearchControls object.
	 * @return List<LdapEntry>
	 * @throws NamingException from create method.
	 */
	public List<LdapEntry> search(String principal, String password, String filter, SearchControls searchControls) throws NamingException {
		LdapContext context = ldapContextFactory.create(principal, password);
		return LdapUtils.search(context, ldapProperties.getBaseDn(), filter);
	}

	/**
	 * Search data in LDAP.
	 * @param principal Principal in LDAP system, sometimes its a login name.
	 * @param password Password for specific entry in LDAP.
	 * @param filter Filter expression such as {{field name}}={{value}}
	 * @param attributes LDAP entry attributes which need.
	 * @return List<LdapEntry>
	 * @throws NamingException from create method.
	 */
	public List<LdapEntry> search(String principal, String password, String filter, String[] attributes) throws NamingException {
		return this.search(principal, password, filter, LdapUtils.searchControls(attributes));
	}

	/**
	 * Return one LdapEntry object by calling search method.
	 * @param principal Principal in LDAP system, sometimes its a login name.
	 * @param password Password for specific entry in LDAP.
	 * @param filter Filter expression such as {{field name}}={{value}}
	 * @param searchControls SearchControls object.
	 * @return LdapEntry
	 * @throws NamingException from create method.
	 */
	public LdapEntry findOne(String principal, String password, String filter, SearchControls searchControls) throws NamingException {
		List<LdapEntry> list = this.search(principal, password, filter, searchControls);

		if (CollectionUtils.isNullOrEmpty(list)) {
			return null;
		}

		return list.get(0);
	}

	/**
	 * Return one LdapEntry object by calling search method.
	 * @param principal Principal in LDAP system, sometimes its a login name.
	 * @param password Password for specific entry in LDAP.
	 * @param filter Filter expression such as {{field name}}={{value}}
	 * @param attributes LDAP entry attributes which need.
	 * @return LdapEntry
	 * @throws NamingException from create method.
	 */
	public LdapEntry findOne(String principal, String password, String filter, String[] attributes) throws NamingException {
		return findOne(principal, password, filter, LdapUtils.searchControls(attributes));
	}

	/**
	 * Return one LdapEntry object by calling search method.
	 * @param principal Principal in LDAP system, sometimes its a login name.
	 * @param password Password for specific entry in LDAP.
	 * @param filter Filter expression such as {{field name}}={{value}}
	 * @return LdapEntry
	 * @throws NamingException from create method.
	 */
	public LdapEntry findOne(String principal, String password, String filter) throws NamingException {
		return findOne(principal, password, filter, LdapUtils.searchControls());
	}

	public LdapProperties getLdapProperties() {
		return ldapProperties;
	}
}