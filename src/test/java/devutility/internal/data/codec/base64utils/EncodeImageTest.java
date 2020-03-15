package devutility.internal.data.codec.base64utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import devutility.internal.data.codec.Base64Utils;
import devutility.internal.io.StreamUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class EncodeImageTest extends BaseTest {
	@Override
	public void run() {
		try {
			byte[] bytes = StreamUtils.read(new FileInputStream("E:\\Downloads\\Test\\cropped.jpg"));
			println(Base64Utils.encodeToString(bytes));
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(EncodeImageTest.class);
	}
}