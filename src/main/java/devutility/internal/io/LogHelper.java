package devutility.internal.io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import devutility.internal.lang.ExceptionHelper;
import devutility.internal.lang.StringHelper;

public class LogHelper {
	// region variables

	private static final String fileNameFormat_Exception = "exception_%s";

	// endregion

	// region get Log Root Directory

	public static String getLogRootDirectory() throws IOException {
		String projectDirectory = DirectoryHelper.getProjectDirectory();

		if (projectDirectory == null) {
			throw new IOException("Cannot get project directory!");
		}

		return Paths.get(projectDirectory, "data", "logs").toString();
	}

	// endregion

	// region get file name

	public static String getLogFileName(String fileNameFormat, LocalDateTime dateTime) {
		String hourLogFileName = FileHelper.getHourLogFileName(dateTime.getHour());

		if (StringHelper.isNullOrEmpty(fileNameFormat)) {
			return hourLogFileName;
		}

		return String.format(fileNameFormat, hourLogFileName);
	}

	// endregion

	// region save

	public static void save(String rootDirectory, LocalDateTime dateTime, String fileNameFormat, String content) throws IOException {
		String logDirectory = DirectoryHelper.getDateDirectory(rootDirectory, dateTime);

		if (!DirectoryHelper.createIfNon(logDirectory)) {
			throw new IOException(String.format("Cannot create directory %s", logDirectory));
		}

		String fileName = getLogFileName(fileNameFormat, dateTime);
		Path path = Paths.get(logDirectory, fileName);
		TextFileHelper.asyncAppend(path, content);
	}

	public static void save(LocalDateTime dateTime, String fileNameFormat, String content) throws IOException {
		String rootDirectory = getLogRootDirectory();
		save(rootDirectory, dateTime, fileNameFormat, content);
	}

	public static void save(String rootDirectory, String fileNameFormat, String content) throws IOException {
		save(rootDirectory, LocalDateTime.now(), fileNameFormat, content);
	}

	public static void save(String fileNameFormat, String content) throws IOException {
		save(LocalDateTime.now(), fileNameFormat, content);
	}

	public static void save(String content) throws IOException {
		save(null, content);
	}

	public static void save(String rootDirectory, LocalDateTime dateTime, Exception exception) throws Exception {
		save(rootDirectory, dateTime, fileNameFormat_Exception, ExceptionHelper.toString(exception));
	}

	// endregion
}