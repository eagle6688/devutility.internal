package devutility.internal.test.security.ecc;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import devutility.internal.security.EccUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetPublicKeyTest extends BaseTest {
	@Override
	public void run() {
		try {
			println(EccUtils.getPublicKey("asd"));
		} catch (UnsupportedEncodingException | GeneralSecurityException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetPublicKeyTest.class);
	}
}