package devutility.internal.test;

import java.util.Arrays;

public abstract class BaseTest {
	/**
	 * Print string in a new line.
	 * @param value: String value.
	 */
	protected static void println(String value) {
		System.out.println(value);
	}

	/**
	 * Print int value in a new line.
	 * @param value: Int value.
	 */
	protected static void println(int value) {
		System.out.println(value);
	}

	/**
	 * Print long value in a new line.
	 * @param value: Long value.
	 */
	protected static void println(long value) {
		System.out.println(value);
	}

	/**
	 * Print string value with specified format in a new line.
	 * @param format: String format.
	 * @param args: String args.
	 */
	protected static void println(String format, String... args) {
		if (args == null || args.length == 0) {
			return;
		}

		String value = String.format(format, Arrays.asList());
		println(value);
	}

	/**
	 * Print string value with specified format in a new line.
	 * @param format: String format.
	 * @param args: Objects.
	 */
	protected static void println(String format, Object... args) {
		if (args == null || args.length == 0) {
			return;
		}

		String value = String.format(format, args);
		println(value);
	}

	/**
	 * Run method, sub class should implement this method.
	 */
	public abstract void run();
}