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
	private LdapProperties ldapProperties;

	public LdapHelper() {
	}

	public LdapHelper(LdapProperties ldapProperties) {
		this.setLdapProperties(ldapProperties);
	}

	public LdapProperties getLdapProperties() {
		return ldapProperties;
	}

	public void setLdapProperties(LdapProperties ldapProperties) {
		this.ldapProperties = ldapProperties;
	}

	public LdapEntry findOne(String principal, String password, String filter, SearchControls searchControls) throws NamingException {
		LdapContext context = LdapUtils.ldapContext(ldapProperties.getUrl(), principal, password);
		List<LdapEntry> list = LdapUtils.search(context, ldapProperties.getBaseDn(), filter);

		if (CollectionUtils.isNullOrEmpty(list)) {
			return null;
		}

		return list.get(0);
	}

	public LdapEntry findOne(String principal, String password, String filter, String[] attributes) throws NamingException {
		return findOne(principal, password, filter, LdapUtils.searchControls(attributes));
	}

	public LdapEntry findOne(String principal, String password, String filter) throws NamingException {
		return findOne(principal, password, filter, LdapUtils.searchControls());
	}
}