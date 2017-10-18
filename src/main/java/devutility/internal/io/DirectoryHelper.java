package devutility.internal.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DirectoryHelper {
	public static String getProjectDirectory() {
		return System.getProperty("user.dir");
	}

	public static Path getResourcesDirectoryPath() {
		String projectDir = getProjectDirectory();
		String resourcesDirectory = Paths.get("src", "main", "resources").toString();
		return Paths.get(projectDir, resourcesDirectory);
	}

	public static String getResourcesDirectory() {
		return getResourcesDirectoryPath().toString();
	}

	public static String getAbsolutePath(String relativePath) throws IOException {
		if (relativePath.indexOf("./") == 0 || relativePath.indexOf("../") == 0) {
			return new File(relativePath).getCanonicalPath();
		}

		return new File(relativePath).getAbsolutePath();
	}

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