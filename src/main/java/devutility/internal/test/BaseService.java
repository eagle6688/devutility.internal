package devutility.internal.test;

import java.util.Arrays;

public abstract class BaseService {
	protected static void println(String message) {
		System.out.println(message);
	}

	protected static void println(int value) {
		println(String.valueOf(value));
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

	public abstract void run();
}