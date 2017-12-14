package devutility.internal.system;

public class SystemHelper {
	// region get new line char

	public static String getNewLineChar() {
		return System.getProperty("line.separator");
	}

	// endregion

	// region get path separator

	public static String getPathSeparator() {
		return System.getProperty("path.separator");
	}

	// endregion

	// region get file separator

	public static String getFileSeparator() {
		return System.getProperty("file.separator");
	}

	// endregion

	// region get processors count

	public static int getProcessorsCount() {
		return Runtime.getRuntime().availableProcessors();
	}

	// endregion

	// region get proper processors count

	public static int getProperProcessorsCount() {
		return getProcessorsCount() * 3 / 4;
	}

	// endregion
}