package devutility.internal.security.ldap;

import java.util.List;

import javax.naming.NamingException;
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

	public LdapEntry getAdAccount(String userName, String password) throws NamingException {
		LdapContext context = LdapUtils.ldapContext(ldapUrl, userName, password);
		List<LdapEntry> list = LdapUtils.search(context, baseDn, LdapUtils.getActiveDirectoryFilter(userName));

		if (CollectionUtils.isNullOrEmpty(list)) {
			return null;
		}

		return list.get(0);
	}
}