package devutility.internal.security.ecc;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

import devutility.internal.security.EccUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetPrivateKeyTest extends BaseTest {
	@Override
	public void run() {
		try {
			println(EccUtils.getPrivateKey("asd"));
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetPrivateKeyTest.class);
	}
}