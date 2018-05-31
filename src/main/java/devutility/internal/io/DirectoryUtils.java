package devutility.internal.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DirectoryUtils {
	/**
	 * Create directory if not exists.
	 * @param directory: Directory want to create.
	 * @return boolean
	 */
	public static boolean createIfNon(File directory) {
		if (directory.exists()) {
			return true;
		}

		return directory.mkdirs();
	}

	/**
	 * Create directory if not exists.
	 * @param directory: Directory want to create.
	 * @return boolean
	 */
	public static boolean createIfNon(String directory) {
		return createIfNon(new File(directory));
	}

	/**
	 * Get project directory.
	 * @return String
	 */
	public static String getProjectDirectory() {
		File file = new File("");
		return file.getAbsolutePath();
	}

	/**
	 * Get resources directory.
	 * @return String
	 */
	public static String getResourcesDirectory() {
		URL url = DirectoryUtils.class.getClassLoader().getResource("");
		URI uri = null;

		try {
			uri = url.toURI();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}

		if (uri == null) {
			return null;
		}

		File file = new File(uri);

		if (!file.exists()) {
			return null;
		}

		return Paths.get(file.getParent(), "classes").toString();
	}

	/**
	 * Convert to absolute path.
	 * @param relativePath: Relative path.
	 * @return String
	 * @throws IOException
	 */
	public static String toAbsolutePath(String relativePath) throws IOException {
		if (relativePath.indexOf("./") == 0 || relativePath.indexOf("../") == 0) {
			return new File(relativePath).getCanonicalPath();
		}

		String projectDirectory = getProjectDirectory();
		return Paths.get(projectDirectory, relativePath).toString();
	}

	/**
	 * Get date directory.
	 * @return String
	 */
	public static String getDateDirectory() {
		return getDateDirectory("");
	}

	/**
	 * Get date directory with root directory ahead.
	 * @param rootDir: Root directory.
	 * @return String
	 */
	public static String getDateDirectory(String rootDir) {
		return getDateDirectory(rootDir, LocalDate.now());
	}

	/**
	 * Get date directory with root directory ahead and specified date.
	 * @param rootDir: Root directory.
	 * @param date: Date in LocalDate.
	 * @return String
	 */
	public static String getDateDirectory(String rootDir, LocalDate date) {
		return Paths.get(rootDir, String.valueOf(date.getYear()), String.valueOf(date.getMonthValue()), String.valueOf(date.getDayOfMonth())).toString();
	}

	/**
	 * Get date directory with root directory ahead and specified dateTime.
	 * @param rootDir: Root directory.
	 * @param dateTime: DateTime in LocalDateTime.
	 * @return String
	 */
	public static String getDateDirectory(String rootDir, LocalDateTime dateTime) {
		return Paths.get(rootDir, String.valueOf(dateTime.getYear()), String.valueOf(dateTime.getMonthValue()), String.valueOf(dateTime.getDayOfMonth())).toString();
	}
}