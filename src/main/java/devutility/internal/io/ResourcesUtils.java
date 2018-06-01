package devutility.internal.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourcesUtils {
	/**
	 * Get InputStream by default loading order.
	 * @param resource: Resource file name.
	 * @return InputStream
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public static InputStream getInputStream(String resource) throws URISyntaxException, IOException {
		String projectDirectory = DirectoryUtils.getProjectDirectory();
		URL url = DirectoryUtils.class.getClassLoader().getResource(resource);

		/**
		 * Rank 1: Local resources path.
		 */
		if (url != null && "file".equals(url.getProtocol())) {
			File file = new File(url.toURI());
			String path = file.getAbsolutePath();

			if (file.exists() && path.indexOf(projectDirectory) == 0) {
				return new FileInputStream(file);
			}
		}

		/**
		 * Rank 2: Project directory.
		 */
		Path resourcePath = Paths.get(projectDirectory, resource);
		File resourceFile = resourcePath.toFile();

		if (resourceFile.exists()) {
			return new FileInputStream(resourceFile);
		}

		/**
		 * Rank 3: Other project resources path.
		 */
		if (url != null && "file".equals(url.getProtocol())) {
			File file = new File(url.toURI());

			if (file.exists()) {
				return new FileInputStream(file);
			}
		}

		/**
		 * Rank 4: Dependent jar package file.
		 */
		if (url != null && "jar".equals(url.getProtocol())) {
			return url.openStream();
		}

		return null;
	}
}