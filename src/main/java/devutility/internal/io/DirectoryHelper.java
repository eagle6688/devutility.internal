package devutility.internal.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DirectoryHelper {
	// region get project directory

	public static String getProjectDirectory() {
		String directory = "";

		try {
			URI uri = Thread.currentThread().getContextClassLoader().getResource("").toURI();
			File file = new File(uri);
			directory = file.getParentFile().getParentFile().getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return directory;
	}

	// endregion

	// region get resource directory path

	public static Path getResourcesDirectoryPath() {
		String projectDir = getProjectDirectory();
		String resourcesDirectory = Paths.get("src", "main", "resources").toString();
		return Paths.get(projectDir, resourcesDirectory);
	}

	public static String getResourcesDirectory() {
		return getResourcesDirectoryPath().toString();
	}

	// endregion

	// region get web directory

	public static Path getWebDirectoryPath() {
		String projectDir = getProjectDirectory();
		String webDirectory = Paths.get("src", "main", "webapp").toString();
		return Paths.get(projectDir, webDirectory);
	}

	public static String getWebDirectory() {
		return getWebDirectoryPath().toString();
	}

	// endregion

	// region to absolute path

	public static String toAbsolutePath(String relativePath) throws IOException {
		if (relativePath.indexOf("./") == 0 || relativePath.indexOf("../") == 0) {
			return new File(relativePath).getCanonicalPath();
		}

		String projectDirectory = getProjectDirectory();
		return Paths.get(projectDirectory, relativePath).toString();
	}

	// endregion

	// region get date directory

	public static String getDateDirectory() {
		return getDateDirectory("");
	}

	public static String getDateDirectory(String rootDir) {
		return getDateDirectory(LocalDate.now(), rootDir);
	}

	public static String getDateDirectory(LocalDate date, String rootDir) {
		return Paths.get(rootDir, String.valueOf(date.getYear()), String.valueOf(date.getMonthValue()), String.valueOf(date.getDayOfMonth())).toString();
	}

	public static String getDateDirectory(LocalDateTime dateTime, String rootDir) {
		return Paths.get(rootDir, String.valueOf(dateTime.getYear()), String.valueOf(dateTime.getMonthValue()), String.valueOf(dateTime.getDayOfMonth())).toString();
	}

	// endregion

	// region create

	public static boolean createIfNon(File directory) {
		if (directory.exists()) {
			return true;
		}

		return directory.mkdirs();
	}

	public static boolean createIfNon(String directory) {
		return createIfNon(new File(directory));
	}

	// endregion
}