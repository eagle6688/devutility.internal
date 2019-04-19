package devutility.internal.test.security.ldap;

import devutility.internal.security.ldap.LdapEntry;
import devutility.internal.security.ldap.LdapUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class QueryTest extends BaseTest {
	private String host = "lenovo.com";
	private String loginName = "sufb1@lenovo.com";
	private String password = "asd.0123";

	@Override
	public void run() {
		LdapEntry result = LdapUtils.getLdapAccount(loginName, password, host);
		println(result.size());
	}

	public static void main(String[] args) {
		TestExecutor.run(QueryTest.class);
	}
}