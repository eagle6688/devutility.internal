package devutility.internal.util;

import java.util.Random;

public class RandomHelper {
	/**
	 * Random instance
	 */
	private static final Random RANDOM = new Random();

	/**
	 * Get random string
	 * @param chars: Chars pool which will generate random string.
	 * @param length: Chars length
	 * @return String
	 */
	public static String getString(char[] chars, int length) {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < length; i++) {
			buffer.append(chars[RANDOM.nextInt(chars.length)]);
		}

		return buffer.toString();
	}

	/**
	 * Get random number
	 * @param bound: Scope for random number.
	 * @return int
	 */
	public static int getNumber(int bound) {
		return RANDOM.nextInt(bound);
	}
}