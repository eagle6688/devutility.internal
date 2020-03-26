package devutility.internal.security;

import java.io.UnsupportedEncodingException;

import devutility.internal.data.codec.Utf8Utils;
import devutility.internal.data.converter.ConverterUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class Md5UtilsTest extends BaseTest {
	@Override
	public void run() {
		String value = "Hello World!";
		println(Md5Utils.encipherToBase64(value));
		println(Md5Utils.encipherToHex(value));

		byte[] bytes = null;

		try {
			bytes = Utf8Utils.encode(value);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		byte[] encipheredBytes = Md5Utils.encipher(bytes);
		println(ConverterUtils.bytesToHex(encipheredBytes));
		println(ConverterUtils.bytesToLong(encipheredBytes));
	}

	public static void main(String[] args) {
		TestExecutor.run(Md5UtilsTest.class);
	}
}