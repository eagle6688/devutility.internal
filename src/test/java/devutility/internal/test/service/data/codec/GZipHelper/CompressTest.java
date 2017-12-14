package devutility.internal.test.service.data.codec.GZipHelper;

import devutility.internal.data.codec.GZipHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CompressTest extends BaseTest {
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
		TestExecutor.run(CompressTest.class);
	}
}