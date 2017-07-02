package devutility.internal.io;

import java.io.File;

public class FileHelper {
	public static boolean exists(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}

	public static long getBytesLength(String fileName) {
		File file = new File(fileName);

		if (!file.exists()) {
			return 0;
		}

		return file.length();
	}
}