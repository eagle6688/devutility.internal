package devutility.internal.io;

import java.io.File;
import java.nio.file.Path;

public class FileUtils {
	public static boolean exists(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}

	public static long getBytesLength(File file) {
		if (!file.exists()) {
			return 0;
		}

		return file.length();
	}

	public static long getBytesLength(Path path) {
		File file = path.toFile();
		return getBytesLength(file);
	}

	public static long getBytesLength(String fileName) {
		File file = new File(fileName);
		return getBytesLength(file);
	}

	public static String getHourLogFileName(int hour) {
		return String.format("%d.log", hour);
	}

	public static String getFileExtension(String fileName) {
		int index = fileName.lastIndexOf(".");
		return fileName.substring(index + 1);
	}
}