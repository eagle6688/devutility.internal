package devutility.internal.test.service.data.codec.Base64Helper;

import devutility.internal.data.codec.Base64Helper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class EncodeTest extends BaseService {
	@Override
	public void run() {
		String value = "Hellp World!Hello World!";
		byte[] bytes = value.getBytes();
		byte[] base64Bytes = Base64Helper.encode(bytes);
		String base64String = new String(base64Bytes);
		println(base64String);
	}

	public static void main(String[] args) {
		ServiceExecutor.run(EncodeTest.class);
	}
}