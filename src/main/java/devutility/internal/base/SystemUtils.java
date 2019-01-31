package devutility.internal.base;

import java.util.UUID;

public class SystemUtils {
	/**
	 * Get line separator.
	 * @return String
	 */
	public static String lineSeparator() {
		return System.getProperty("line.separator");
	}

	/**
	 * Get path separator.
	 * @return String
	 */
	public static String pathSeparator() {
		return System.getProperty("path.separator");
	}

	/**
	 * Get file separator.
	 * @return String
	 */
	public static String fileSeparator() {
		return System.getProperty("file.separator");
	}

	/**
	 * Return processors count.
	 * @return int
	 */
	public static int processorsCount() {
		return Runtime.getRuntime().availableProcessors();
	}

	/**
	 * Return proper processors count for programe usage.
	 * @return int
	 */
	public static int properProcessorsCount() {
		return processorsCount() * 3 / 4;
	}

	/**
	 * Return a new UUID.
	 * @return String
	 */
	public static String uuid() {
		return UUID.randomUUID().toString();
	}
}