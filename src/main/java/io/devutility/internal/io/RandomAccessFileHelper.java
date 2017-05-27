package devutility.internal.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileHelper {
	public static final int BUFFERSIZE = 1024;

	public static void insert(String fileName, long startIndex, String value) throws IOException {
		if (!FileHelper.exists(fileName)) {
			return;
		}

		try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
			long length = randomAccessFile.length();

			if (startIndex < 0 || startIndex > length) {
				return;
			}

			byte[] valueBytes = value.getBytes();
			int valueLength = valueBytes.length;
			randomAccessFile.setLength(length + valueLength);

			for (long i = length - 1; i > startIndex - 1; i--) {
				randomAccessFile.seek(i);
				byte temp = randomAccessFile.readByte();
				randomAccessFile.seek(i + valueLength);
				randomAccessFile.write(temp);
			}

			randomAccessFile.seek(startIndex);
			randomAccessFile.write(valueBytes);
		} catch (IOException e) {
			throw e;
		}
	}

	public static void append(String fileName, String value) throws IOException {
		insert(fileName, FileHelper.getBytesLength(fileName), value);
	}
}