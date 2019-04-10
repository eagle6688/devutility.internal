package devutility.internal.data.codec;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * 
 * Base64Utils
 * 
 * @author: Aldwin Su
 */
public class Base64Utils {
	/**
	 * Encode bytes array to base64 bytes.
	 * @param bytes bytes array.
	 * @return byte[]
	 */
	public static byte[] encode(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		return Base64.getEncoder().encode(bytes);
	}

	public static String encodeToString(byte[] bytes) throws UnsupportedEncodingException {
		byte[] base64Bytes = encode(bytes);
		return Utf8Utils.decode(base64Bytes);
	}

	public static byte[] decode(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		return Base64.getDecoder().decode(bytes);
	}

	/**
	 * Decode base64 string to bytes array.
	 * @param value Base64 string value.
	 * @return {@code byte[]}
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] decode(String value) throws UnsupportedEncodingException {
		byte[] base64Bytes = Utf8Utils.encode(value);
		return decode(base64Bytes);
	}

	/**
	 * Decode base64 string and save to File.
	 * @param value Base64 string value.
	 * @param file File object.
	 * @throws IOException
	 */
	public static void decodeToFile(String value, File file) throws IOException {
		byte[] bytes = Base64.getDecoder().decode(value);

		if (bytes == null || bytes.length == 0) {
			return;
		}

		OutputStream outputStream = new FileOutputStream(file);
		outputStream.write(bytes);
		outputStream.flush();
		outputStream.close();
	}
}