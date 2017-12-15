package devutility.internal.io;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import devutility.internal.io.FileHelper;
import devutility.internal.io.RandomAccessFileHelper;
import devutility.internal.system.SystemHelper;

public class TextFileHelper {
	// region insert

	/**
	 * Insert content in a file.
	 * 
	 * @param startIndex
	 *            startIndex of file content bytes.
	 */
	public static void insert(String fileName, long startIndex, String content) throws Exception {
		byte[] bytes = content.getBytes();
		RandomAccessFileHelper.insert(fileName, startIndex, bytes);
	}

	// endregion

	// region append

	/**
	 * Append content in a file.
	 */
	public static void append(String fileName, String content) throws Exception {
		insert(fileName, FileHelper.getBytesLength(fileName), content);
	}

	/**
	 * Append a new line content in a file.
	 */
	public static void appendLine(String fileName, String content) throws Exception {
		StringBuffer stringBuffer = new StringBuffer(SystemHelper.getNewLineChar());
		stringBuffer.append(content);
		append(fileName, stringBuffer.toString());
	}

	// endregion

	// region async append

	public static void asyncAppend(String fileName, ByteBuffer byteBuffer) throws IOException {
		Path path = Paths.get(fileName);
		RandomAccessFileHelper.asyncAppend(path, byteBuffer);
	}

	public static void asyncAppend(Path path, String content) throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.wrap(content.getBytes());
		RandomAccessFileHelper.asyncAppend(path, byteBuffer);
	}

	// endregion

	// region read

	/**
	 * Read text
	 * 
	 * @throws IOException
	 */
	public static String read(String fileName, Charset charset) throws IOException {
		File file = new File(fileName);

		if (!file.exists()) {
			return null;
		}

		byte[] bytes = Files.readAllBytes(file.toPath());

		if (bytes == null) {
			return null;
		}

		return new String(bytes, charset);
	}

	// endregion
}