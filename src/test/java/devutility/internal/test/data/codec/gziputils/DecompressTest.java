package devutility.internal.test.data.codec.gziputils;

import devutility.internal.data.codec.GzipUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class DecompressTest extends BaseTest {
	@Override
	public void run() {
		String value = "Hello World!Hello World!Hello World!Hello World!";
		byte[] bytes = value.getBytes();

		try {
			byte[] compressedBytes = GzipUtils.compress(bytes);
			byte[] unCompressedBytes = GzipUtils.decompress(compressedBytes);
			System.out.println(new String(unCompressedBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(DecompressTest.class);
	}
}