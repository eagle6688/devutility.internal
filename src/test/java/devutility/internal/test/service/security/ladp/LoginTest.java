package devutility.internal.test.service.security.ladp;

import devutility.internal.security.LadpHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class LoginTest extends BaseTest {
	@Override
	public void run() {
		boolean result = LadpHelper.login("", "", "");
		System.out.println(result);
	}

	public static void main(String[] args) {
		TestExecutor.run(LoginTest.class);
	}
}