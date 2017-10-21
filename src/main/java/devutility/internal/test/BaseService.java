package devutility.internal.test;

import java.util.Arrays;

public abstract class BaseService {
	protected void println(String message) {
		System.out.println(message);
	}

	protected void println(int value) {
		println(String.valueOf(value));
	}

	protected void println(String format, String... args) {
		if (args == null || args.length == 0) {
			return;
		}

		String value = String.format(format, Arrays.asList(args));
		println(value);
	}

	public abstract void run();
}