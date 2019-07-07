package devutility.internal.test.data.codec.gziputils;

import devutility.internal.data.codec.GzipUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CompressTest extends BaseTest {
	@Override
	public void run() {
		String value = "Hello World!";

		try {
			byte[] bytes = value.getBytes();
			println(bytes.length);

			byte[] compressedBytes = GzipUtils.compress(bytes);
			println(compressedBytes.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(CompressTest.class);
	}
}