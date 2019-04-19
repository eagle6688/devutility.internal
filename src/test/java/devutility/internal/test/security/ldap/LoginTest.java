package devutility.internal.test.security.ldap;

import devutility.internal.security.ldap.LdapUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class LoginTest extends BaseTest {
	@Override
	public void run() {
		String loginName = "";
		String password = "";
		String host = "";
		boolean result = LdapUtils.login(loginName, password, host);
		System.out.println(result);
	}

	public static void main(String[] args) {
		TestExecutor.run(LoginTest.class);
	}
}