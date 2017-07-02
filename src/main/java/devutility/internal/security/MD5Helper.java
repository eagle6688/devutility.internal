package devutility.internal.security;

import java.io.File;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

public class MD5Helper {

	public static String encipherFile(String path) {
		File file = new File(path);

		if (!file.exists() || file.isDirectory()) {
			return "";
		}

		try {
			FileChannel fileChannel = FileChannel.open(file.toPath(), StandardOpenOption.READ);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "";
	}
}