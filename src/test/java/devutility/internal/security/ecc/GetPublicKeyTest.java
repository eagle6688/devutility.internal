package devutility.internal.security.ecc;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import devutility.internal.security.cipher.EccUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetPublicKeyTest extends BaseTest {
	@Override
	public void run() {
		try {
			println(EccUtils.getPublicKey());
		} catch (UnsupportedEncodingException | GeneralSecurityException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetPublicKeyTest.class);
	}
}