package devutility.internal.io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import devutility.internal.lang.ExceptionUtils;
import devutility.internal.lang.StringUtils;

public class LogUtils {
	private static final String FILENAMEFORMAT_EXCEPTION = "exception_%s";

	public static String getLogRootDirectory() throws IOException {
		String projectDirectory = DirectoryUtils.getProjectDirectory();

		if (projectDirectory == null) {
			throw new IOException("Cannot get project directory!");
		}

		return Paths.get(projectDirectory, "data", "logs").toString();
	}

	public static String getLogFileName(String fileNameFormat, LocalDateTime dateTime) {
		String hourLogFileName = FileUtils.getHourLogFileName(dateTime.getHour());

		if (StringUtils.isNullOrEmpty(fileNameFormat)) {
			return hourLogFileName;
		}

		return String.format(fileNameFormat, hourLogFileName);
	}

	public static void save(String rootDirectory, LocalDateTime dateTime, String fileNameFormat, String content) throws IOException {
		String logDirectory = DirectoryUtils.getDateDirectory(rootDirectory, dateTime);

		if (!DirectoryUtils.createIfNon(logDirectory)) {
			throw new IOException(String.format("Cannot create directory %s", logDirectory));
		}

		String fileName = getLogFileName(fileNameFormat, dateTime);
		Path path = Paths.get(logDirectory, fileName);
		TextFileUtils.asyncAppend(path, content);
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
		save(rootDirectory, dateTime, FILENAMEFORMAT_EXCEPTION, ExceptionUtils.toString(exception));
	}
}