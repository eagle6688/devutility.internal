package devutility.internal.test.service.data.codec.Base64Helper;

import devutility.internal.data.codec.Base64Helper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class DecodeTest extends BaseService {
	@Override
	public void run() {
		String value = "Hellp World!Hello World!";
		byte[] bytes = value.getBytes();
		byte[] base64Bytes = Base64Helper.encode(bytes);
		byte[] originalBytes = Base64Helper.decode(base64Bytes);
		String originalValue = new String(originalBytes);
		println(originalValue);
	}

	public static void main(String[] args) {
		ServiceExecutor.run(DecodeTest.class);
	}
}