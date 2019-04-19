package devutility.internal.test.security.ldap;

import devutility.internal.security.ldap.LdapAccount;
import devutility.internal.security.ldap.LdapUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class QueryTest extends BaseTest {
	@Override
	public void run() {
		String loginName = "";
		String password = "";
		String host = "";
		LdapAccount result = LdapUtils.getLdapAccount(loginName, password, host);
		println(result != null ? result.get("displayName").get(0) : "");
		println(loginName);
	}

	public static void main(String[] args) {
		TestExecutor.run(QueryTest.class);
	}
}