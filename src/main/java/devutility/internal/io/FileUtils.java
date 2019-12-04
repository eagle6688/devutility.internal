package devutility.internal.io;

import java.io.File;
import java.nio.file.Path;

/**
 * 
 * FileUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-12-04 22:24:43
 */
public class FileUtils {
	/**
	 * Check file exists or not?
	 * @param fileName File name or path.
	 * @return boolean
	 */
	public static boolean exists(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}

	/**
	 * Get size of provided File object.
	 * @param file File object.
	 * @return long
	 */
	public static long getSize(File file) {
		if (!file.exists()) {
			return 0;
		}

		return file.length();
	}

	/**
	 * Get size of provided Path object.
	 * @param path Path object.
	 * @return long
	 */
	public static long getSize(Path path) {
		return getSize(path.toFile());
	}

	/**
	 * Get size of provided file.
	 * @param fileName File name or path.
	 * @return long
	 */
	public static long getSize(String fileName) {
		File file = new File(fileName);
		return getSize(file);
	}

	/**
	 * Get file extension.
	 * @param fileName File name or path.
	 * @return String
	 */
	public static String getExtension(String fileName) {
		int index = fileName.lastIndexOf(".");
		return fileName.substring(index);
	}
}