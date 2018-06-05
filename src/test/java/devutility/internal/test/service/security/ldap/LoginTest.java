package devutility.internal.test.service.security.ldap;

import devutility.internal.security.ldap.LdapUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class LoginTest extends BaseTest {
	@Override
	public void run() {
		boolean result = LdapUtils.login("", "", "");
		System.out.println(result);
	}

	public static void main(String[] args) {
		TestExecutor.run(LoginTest.class);
	}
}