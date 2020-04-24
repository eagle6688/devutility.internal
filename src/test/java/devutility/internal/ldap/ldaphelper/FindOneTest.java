package devutility.internal.ldap.ldaphelper;

import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import devutility.internal.ldap.BaseLdapTest;
import devutility.internal.ldap.LdapEntry;
import devutility.internal.ldap.LdapHelper;
import devutility.internal.ldap.LdapUtils;
import devutility.internal.test.TestExecutor;

public class FindOneTest extends BaseLdapTest {
	@Override
	public void run() {
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
		TestExecutor.run(FindOneTest.class);
	}
}