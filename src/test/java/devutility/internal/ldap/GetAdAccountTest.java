package devutility.internal.ldap;

import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetAdAccountTest extends BaseTest {
	private LdapProperties ldapProperties = new LdapProperties();
	private String providerUrl = "";
	private String domain = "";
	private String userName = "";
	private String password = "";

	@Override
	public void run() {
		ldapProperties.setUrl(providerUrl);
		ldapProperties.setBaseDn(LdapUtils.getDomainComponent(domain));

		LdapHelper ldapHelper = new LdapHelper(ldapProperties);
		LdapEntry ldapEntry = null;

		try {
			ldapEntry = ldapHelper.findOne(userName + "@" + domain, password, LdapUtils.getActiveDirectoryFilter(userName));
		} catch (NamingException e) {
			e.printStackTrace();
		}

		if (ldapEntry == null) {
			println("Not found!");
			return;
		}

		for (Map.Entry<String, List<String>> entry : ldapEntry.entrySet()) {
			println(entry.getKey() + ":" + entry.getValue());
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetAdAccountTest.class);
	}
}