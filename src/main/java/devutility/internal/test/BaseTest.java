package devutility.internal.test;

import java.util.Arrays;

public abstract class BaseTest {
	// region println

	protected static void println(String message) {
		System.out.println(message);
	}

	protected static void println(int value) {
		System.out.println(value);
	}

	protected static void println(long value) {
		System.out.println(value);
	}

	protected static void println(String format, String... args) {
		if (args == null || args.length == 0) {
			return;
		}

		String value = String.format(format, Arrays.asList(args));
		println(value);
	}

	protected static void println(String format, Object... args) {
		if (args == null || args.length == 0) {
			return;
		}

		String value = String.format(format, args);
		println(value);
	}

	// endregion

	// region run

	public abstract void run();

	// endregion
}