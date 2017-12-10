package devutility.internal.test.service.security;

import java.io.UnsupportedEncodingException;

import devutility.internal.base.Convertor;
import devutility.internal.data.codec.UTF8Helper;
import devutility.internal.security.MD5Helper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class MD5HelperTest extends BaseService {
	@Override
	public void run() {
		String value = "Hello World!";
		println(MD5Helper.encipherToBase64(value));
		println(MD5Helper.encipherToHex(value));

		byte[] bytes = null;

		try {
			bytes = UTF8Helper.encode(value);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		byte[] encipheredBytes = MD5Helper.encipher(bytes);
		println(Convertor.toHex(encipheredBytes));
		println(Convertor.bytesToLong(encipheredBytes));
	}

	public static void main(String[] args) {
		ServiceExecutor.run(MD5HelperTest.class);
	}
}