package devutility.internal.util;

import java.util.Random;

public class RandomHelper {
	/**
	 * Random instance
	 */
	private static final Random RANDOM = new Random();

	/**
	 * getString
	 * @param chars
	 * @param digit
	 * @return String
	 */
	public static String getString(char[] chars, int digit) {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < digit; i++) {
			buffer.append(chars[RANDOM.nextInt(chars.length)]);
		}

		return buffer.toString();
	}

	/**
	 * getNumber
	 * @param bound
	 * @return int
	 */
	public static int getNumber(int bound) {
		return RANDOM.nextInt(bound);
	}
}