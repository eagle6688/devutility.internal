package devutility.internal.test.service.data.codec.UTF8Helper;

import java.io.UnsupportedEncodingException;

import devutility.internal.data.codec.UTF8Helper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class EncodeTest extends BaseService {
	@Override
	public void run() {
		String value = "Hello World!大家好！";

		try {
			byte[] bytes = UTF8Helper.encode(value);
			String originalValue = UTF8Helper.decode(bytes);
			println(originalValue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServiceExecutor.run(EncodeTest.class);
	}
}