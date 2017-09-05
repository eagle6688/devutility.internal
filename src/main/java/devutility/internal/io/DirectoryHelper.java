package devutility.internal.io;

import java.nio.file.Path;
import java.nio.file.Paths;

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
}