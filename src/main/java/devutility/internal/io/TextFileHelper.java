package devutility.internal.io;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import devutility.internal.io.FileUtils;
import devutility.internal.io.RandomAccessFileHelper;
import devutility.internal.system.SystemHelper;

public class TextFileHelper {
	/**
	 * Insert new content from startIndex.
	 * @param fileName: file name
	 * @param startIndex: Start index of content in file
	 * @param content: New content
	 * @throws Exception
	 */
	public static void insert(String fileName, long startIndex, String content) throws Exception {
		byte[] bytes = content.getBytes();
		RandomAccessFileHelper.insert(fileName, startIndex, bytes);
	}

	/**
	 * Append new content in file.
	 * @param fileName: file name
	 * @param content: New content
	 * @throws Exception
	 */
	public static void append(String fileName, String content) throws Exception {
		insert(fileName, FileUtils.getBytesLength(fileName), content);
	}

	/**
	 * Append content in a new line.
	 * @param fileName: file name
	 * @param content: New content
	 * @throws Exception
	 */
	public static void appendLine(String fileName, String content) throws Exception {
		StringBuffer stringBuffer = new StringBuffer(SystemHelper.getNewLineChar());
		stringBuffer.append(content);
		append(fileName, stringBuffer.toString());
	}

	/**
	 * Async append byteBuffer
	 * @param fileName: file name
	 * @param byteBuffer: ByteBuffer object that need append.
	 * @throws IOException
	 */
	public static void asyncAppend(String fileName, ByteBuffer byteBuffer) throws IOException {
		Path path = Paths.get(fileName);
		RandomAccessFileHelper.asyncAppend(path, byteBuffer);
	}

	/**
	 * Async append new content.
	 * @param path: File path
	 * @param content: New content
	 * @throws IOException
	 */
	public static void asyncAppend(Path path, String content) throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.wrap(content.getBytes());
		RandomAccessFileHelper.asyncAppend(path, byteBuffer);
	}

	/**
	 * Read content from file in charset
	 * @param fileName: File name
	 * @param charset: Encoding type
	 * @return String: Content
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
}