package devutility.internal.util;

import java.util.Random;

public class RandomHelper {
	private static final Random RANDOM = new Random();

	// region get String

	public static String getString(char[] chars, int digit) {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < digit; i++) {
			buffer.append(chars[RANDOM.nextInt(chars.length)]);
		}

		return buffer.toString();
	}

	// endregion
}