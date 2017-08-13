package devutility.internal.basic.net;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class UrlTest {

	public static void main(String[] args) throws Exception {
		System.out.println(getUrlContent("https://www.baidu.com"));
	}

	public static String getUrlContent(String url) throws Exception {
		URL uRL = new URL(url);
		int index = 0;
		byte[] bytes = new byte[1024];
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		try (InputStream inputStream = uRL.openStream()) {
			while ((index = inputStream.read(bytes, 0, bytes.length)) > 0) {
				byteArrayOutputStream.write(bytes, 0, index);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}

		byte[] allBytes = byteArrayOutputStream.toByteArray();
		return new String(allBytes, StandardCharsets.UTF_8);
	}
}