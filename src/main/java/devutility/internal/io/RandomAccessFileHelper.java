package devutility.internal.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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

	//region append
	
	public static void append(String fileName, byte[] bytes) throws Exception {
		append(fileName, ByteBuffer.wrap(bytes));
	}

	public static void append(String fileName, ByteBuffer byteBuffer) throws Exception {
		try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw"); FileChannel fileChannel = randomAccessFile.getChannel()) {
			fileChannel.position(randomAccessFile.length());
			fileChannel.write(byteBuffer);
		} catch (Exception e) {
			throw e;
		}
	}
	
	// endregion

	// region asyncAppend

	public static void asyncAppend(Path path, ByteBuffer byteBuffer) throws Exception {
		long fileLength = FileHelper.getBytesLength(path);

		try (AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
			asynchronousFileChannel.write(byteBuffer, fileLength);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void asyncAppend(String fileName, ByteBuffer byteBuffer) throws Exception {
		Path path = Paths.get(fileName);
		asyncAppend(path, byteBuffer);
	}

	public static void asyncAppend(Path path, String content) throws Exception {
		ByteBuffer byteBuffer = ByteBuffer.wrap(content.getBytes());
		asyncAppend(path, byteBuffer);
	}

	public static void asyncAppend(String fileName, String content) throws Exception {
		ByteBuffer byteBuffer = ByteBuffer.wrap(content.getBytes());
		asyncAppend(fileName, byteBuffer);
	}

	public static void asyncAppend(String fileName, ByteBuffer byteBuffer, CompletionHandler<Integer, ByteBuffer> handler) throws Exception {
		Path path = Paths.get(fileName);
		long fileLength = FileHelper.getBytesLength(fileName);

		try (AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE)) {
			asynchronousFileChannel.write(byteBuffer, fileLength, byteBuffer, handler);
		} catch (Exception e) {
			throw e;
		}
	}

	// endregion
}