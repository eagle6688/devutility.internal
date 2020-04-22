package devutility.internal.ldap;

/**
 * 
 * LdapProperties
 * 
 * @author: Aldwin Su
 * @version: 2019-04-25 10:37:16
 */
public class LdapProperties {
	private String url;
	private String baseDn;
	private String principalPattern;
	private String filterPattern;

	/**
	 * Need validate certificate?
	 */
	private boolean validateCert;

	public LdapProperties() {
	}

	public LdapProperties(String url, String baseDn) {
		this.url = url;
		this.baseDn = baseDn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBaseDn() {
		return baseDn;
	}

	public void setBaseDn(String baseDn) {
		this.baseDn = baseDn;
	}

	public String getPrincipalPattern() {
		return principalPattern;
	}

	public void setPrincipalPattern(String principalPattern) {
		this.principalPattern = principalPattern;
	}

	public String getFilterPattern() {
		return filterPattern;
	}

	public void setFilterPattern(String filterPattern) {
		this.filterPattern = filterPattern;
	}

	public String principal(Object... args) {
		return String.format(principalPattern, args);
	}

	public String filter(Object... args) {
		return String.format(filterPattern, args);
	}

	public boolean isValidateCert() {
		return validateCert;
	}

	public void setValidateCert(boolean validateCert) {
		this.validateCert = validateCert;
	}
}