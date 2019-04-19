package devutility.internal.test.security.ldap;

import devutility.internal.security.ldap.LdapUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class AuthenticateTest extends BaseTest {
	private String providerUrl = "";
	private String principal = "";
	private String password = "";

	@Override
	public void run() {
		System.out.println(LdapUtils.authenticate(providerUrl, principal, password));
	}

	public static void main(String[] args) {
		TestExecutor.run(AuthenticateTest.class);
	}
}