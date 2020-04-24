package devutility.internal.ldap;

import devutility.internal.test.BaseTest;

/**
 * 
 * BaseLdapTest
 * 
 * @author: Aldwin Su
 * @version: 2020-04-24 18:09:25
 */
public abstract class BaseLdapTest extends BaseTest {
	private String providerUrl = "";
	protected String domain = "";
	protected String userName = "";
	protected String password = "";
	protected LdapProperties ldapProperties = new LdapProperties();

	public BaseLdapTest() {
		ldapProperties.setUrl(providerUrl);
		ldapProperties.setBaseDn(LdapUtils.getDomainComponent(domain));
	}
}