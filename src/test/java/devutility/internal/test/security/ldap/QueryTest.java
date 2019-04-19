package devutility.internal.test.security.ldap;

import devutility.internal.security.ldap.LdapEntry;
import devutility.internal.security.ldap.LdapUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class QueryTest extends BaseTest {
	private String providerUrl = "";
	private String principal = "";
	private String password = "";

	@Override
	public void run() {
		LdapEntry result = LdapUtils.getLdapAccount(principal, password, providerUrl);
		println(result.size());
	}

	public static void main(String[] args) {
		TestExecutor.run(QueryTest.class);
	}
}