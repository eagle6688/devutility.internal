package devutility.internal.test.service.basic.nio.charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncodeTest {
	public static void main(String[] args) {
		// Default charset
		System.out.println(Charset.defaultCharset());

		System.out.println(Charset.availableCharsets());

		System.out.println(StandardCharsets.UTF_8);

		// Get charset
		Charset charset = Charset.forName("UTF-8");
		System.out.println(charset);
	}
}