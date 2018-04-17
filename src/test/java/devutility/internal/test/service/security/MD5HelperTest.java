package devutility.internal.test.service.security;

import java.io.UnsupportedEncodingException;

import devutility.internal.base.Convertor;
import devutility.internal.data.codec.UTF8Utils;
import devutility.internal.security.MD5Helper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class MD5HelperTest extends BaseTest {
	@Override
	public void run() {
		String value = "Hello World!";
		println(MD5Helper.encipherToBase64(value));
		println(MD5Helper.encipherToHex(value));

		byte[] bytes = null;

		try {
			bytes = UTF8Utils.encode(value);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		byte[] encipheredBytes = MD5Helper.encipher(bytes);
		println(Convertor.bytesToHex(encipheredBytes));
		println(Convertor.bytesToLong(encipheredBytes));
	}

	public static void main(String[] args) {
		TestExecutor.run(MD5HelperTest.class);
	}
}