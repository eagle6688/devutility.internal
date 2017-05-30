package devutility.internal.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileHelper {
	public static final int BUFFERSIZE = 1024;

	public static void insert(String fileName, long startIndex, byte[] bytes) throws Exception {
		try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
			long fileLength = randomAccessFile.length();

			if (startIndex < 0 || startIndex > fileLength) {
				throw new Exception("startIndex invalid!");
			}

			int bytesLength = bytes.length;
			randomAccessFile.setLength(fileLength + bytesLength);

			for (long i = fileLength - 1; i > startIndex - 1; i--) {
				randomAccessFile.seek(i);
				byte temp = randomAccessFile.readByte();
				randomAccessFile.seek(i + bytesLength);
				randomAccessFile.write(temp);
			}

			randomAccessFile.seek(startIndex);
			randomAccessFile.write(bytes);
		} catch (IOException e) {
			throw e;
		}
	}
	
	public static void append(String fileName, byte[] bytes) throws Exception{
		insert(fileName, FileHelper.getBytesLength(fileName), bytes);
	}
}