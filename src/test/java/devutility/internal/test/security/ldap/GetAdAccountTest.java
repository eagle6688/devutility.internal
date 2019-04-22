package devutility.internal.test.security.ldap;

import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import devutility.internal.security.ldap.LdapEntry;
import devutility.internal.security.ldap.LdapHelper;
import devutility.internal.security.ldap.LdapUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetAdAccountTest extends BaseTest {
	private String providerUrl = "";
	private String domain = "";
	private String userName = "";
	private String password = "";

	@Override
	public void run() {
		LdapHelper ldapHelper = new LdapHelper();
		ldapHelper.setLdapUrl(providerUrl);
		ldapHelper.setBaseDn(LdapUtils.getDomainComponent(domain));

		LdapEntry ldapEntry = null;

		try {
			ldapEntry = ldapHelper.getAdAccount(userName, password);
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