package devutility.internal.test.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import devutility.internal.security.Sha256Utils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SHA256HelperTest extends BaseTest {
	@Override
	public void run() {
		String value = "Hello World!";
		println(Sha256Utils.encipherToHex(value));
		println(getSHA256StrJava(value));
	}

	private static String getSHA256StrJava(String str) {
		MessageDigest messageDigest;
		String encodeStr = "";

		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes("UTF-8"));
			encodeStr = byte2Hex(messageDigest.digest());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return encodeStr;
	}

	private static String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			
			if (temp.length() == 1) {
				stringBuffer.append("0");
			}
			
			stringBuffer.append(temp);
		}
		
		return stringBuffer.toString();
	}

	public static void main(String[] args) {
		TestExecutor.run(SHA256HelperTest.class);
	}
}