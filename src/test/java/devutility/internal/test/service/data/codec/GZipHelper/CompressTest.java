package devutility.internal.test.service.data.codec.GZipHelper;

import devutility.internal.data.codec.GZipHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class CompressTest extends BaseService {
	@Override
	public void run() {
		String value = "Hello World!";

		try {
			byte[] bytes = value.getBytes();
			println(bytes.length);

			byte[] compressedBytes = GZipHelper.compress(bytes);
			println(compressedBytes.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServiceExecutor.run(CompressTest.class);
	}
}