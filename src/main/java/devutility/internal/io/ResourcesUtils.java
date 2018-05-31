package devutility.internal.io;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourcesUtils {
	/**
	 * Find out the resource path by default order.
	 * @param resource: Resource path.
	 * @return String
	 * @throws URISyntaxException
	 */
	public static String getPathByDefaultOrder(String resource) throws URISyntaxException {
		String projectDirectory = DirectoryUtils.getProjectDirectory();
		URL url = DirectoryUtils.class.getClassLoader().getResource(resource);

		/**
		 * Rank 1: Local resources path.
		 */
		if (url != null && "file".equals(url.getProtocol())) {
			File file = new File(url.toURI());
			String path = file.getAbsolutePath();

			if (file.exists() && path.indexOf(projectDirectory) == 0) {
				return path;
			}
		}

		/**
		 * Rank 2: Project directory.
		 */
		Path resourcePath = Paths.get(projectDirectory, resource);
		File resourceFile = resourcePath.toFile();

		if (resourceFile.exists()) {
			return resourceFile.getAbsolutePath();
		}

		/**
		 * Rank 3: Other project resources path.
		 */
		if (url != null && "file".equals(url.getProtocol())) {
			File file = new File(url.toURI());
			String path = file.getAbsolutePath();

			if (file.exists()) {
				return path;
			}
		}

		/**
		 * Rank 4: Other jar package file.
		 */
		if (url != null && "jar".equals(url.getProtocol())) {
			File file = new File(url.toURI());
			return file.getAbsolutePath();
		}

		return null;
	}
}