package devutility.internal.system;

public class SystemHelper {
	public static String getNewLineChar() {
		return System.getProperty("line.separator");
	}

	public static String getPathSeparator() {
		return System.getProperty("path.separator");
	}

	public static String getFileSeparator() {
		return System.getProperty("file.separator");
	}

	public static int getProcessorsCount() {
		return Runtime.getRuntime().availableProcessors();
	}

	public static int getProperProcessorsCount() {
		return getProcessorsCount() * 3 / 4;
	}
}