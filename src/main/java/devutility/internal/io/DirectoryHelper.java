package devutility.internal.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryHelper {
	public static String getProjectDirectory() {
		return System.getProperty("user.dir");
	}

	public static Path getResourcesDirectoryPath() {
		String projectDir = getProjectDirectory();
		Path resourcesDirectory = Paths.get("src", "main", "resources");
		return Paths.get(projectDir, resourcesDirectory.toString());
	}

	public static String getResourcesDirectory() {
		return getResourcesDirectoryPath().toString();
	}
}