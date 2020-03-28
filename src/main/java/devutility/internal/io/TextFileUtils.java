package devutility.internal.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import devutility.internal.com.SystemUtils;
import devutility.internal.data.codec.Utf8Utils;
import devutility.internal.nio.RandomAccessFileUtils;

/**
 * 
 * TextFileUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-04-10 17:39:50
 */
public class TextFileUtils {
	/**
	 * Insert new content from startIndex.
	 * @param file File path.
	 * @param start Start index in file bytes array, not file content index.
	 * @param content New content
	 * @throws IOException From RandomAccessFileUtils
	 */
	public static void insert(String file, long start, String content) throws IOException {
		byte[] bytes = content.getBytes();
		RandomAccessFileUtils.insert(file, start, bytes);
	}

	/**
	 * Append content at the end of file.
	 * @param file File path.
	 * @param content New string content.
	 * @throws IOException From RandomAccessFileUtils.
	 */
	public static void append(String file, String content) throws IOException {
		RandomAccessFileUtils.append(file, Utf8Utils.encode(content));
	}

	/**
	 * Append content in a new line.
	 * @param file File path.
	 * @param content New string content.
	 * @throws IOException From RandomAccessFileUtils.
	 */
	public static void appendLine(String file, String content) throws IOException {
		append(file, SystemUtils.lineSeparator() + content);
	}

	/**
	 * Async append new content.
	 * @param path File path.
	 * @param content New content
	 * @throws IOException From RandomAccessFileUtils.
	 */
	public static void asyncAppend(Path path, String content) throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.wrap(content.getBytes());
		RandomAccessFileUtils.asyncAppend(path, byteBuffer);
	}

	/**
	 * Read content from file in charset.
	 * @param path File path.
	 * @param charset Encoding type.
	 * @return String
	 * @throws IOException From Files.readAllBytes.
	 */
	public static String read(String path, Charset charset) throws IOException {
		File file = new File(path);

		if (!file.exists()) {
			return null;
		}

		byte[] bytes = Files.readAllBytes(file.toPath());

		if (bytes == null) {
			return null;
		}

		return new String(bytes, charset);
	}

	/**
	 * Read content from a InputStream object.
	 * @param inputStream InputStream object.
	 * @param charset Encoding type.
	 * @return String
	 */
	public static String read(InputStream inputStream, Charset charset) {
		byte[] bytes = StreamUtils.read(inputStream);
		return new String(bytes, charset);
	}

	/**
	 * Read content from a InputStream object.
	 * @param inputStream InputStream object.
	 * @return String
	 * @throws UnsupportedEncodingException throw from decode.
	 */
	public static String read(InputStream inputStream) throws UnsupportedEncodingException {
		byte[] bytes = StreamUtils.read(inputStream);
		return Utf8Utils.decode(bytes);
	}
}