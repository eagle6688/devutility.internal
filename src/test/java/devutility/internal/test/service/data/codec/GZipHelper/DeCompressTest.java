package devutility.internal.test.service.data.codec.GZipHelper;

import devutility.internal.data.codec.GZipHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class DeCompressTest extends BaseService {
	@Override
	public void run() {
		String value = "Hello World!Hello World!Hello World!Hello World!";
		byte[] bytes = value.getBytes();

		try {
			byte[] compressedBytes = GZipHelper.compress(bytes);
			byte[] unCompressedBytes = GZipHelper.deCompress(compressedBytes);
			System.out.println(new String(unCompressedBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServiceExecutor.run(DeCompressTest.class);
	}
}