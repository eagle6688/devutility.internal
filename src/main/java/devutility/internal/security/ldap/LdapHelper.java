package devutility.internal.security.ldap;

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
	private String ldapUrl;
	private String baseDn;

	public String getLdapUrl() {
		return ldapUrl;
	}

	public void setLdapUrl(String ldapUrl) {
		this.ldapUrl = ldapUrl;
	}

	public String getBaseDn() {
		return baseDn;
	}

	public void setBaseDn(String baseDn) {
		this.baseDn = baseDn;
	}

	public LdapEntry findOne(String principal, String password, String filter, SearchControls searchControls) throws NamingException {
		LdapContext context = LdapUtils.ldapContext(ldapUrl, principal, password);
		List<LdapEntry> list = LdapUtils.search(context, baseDn, filter);

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