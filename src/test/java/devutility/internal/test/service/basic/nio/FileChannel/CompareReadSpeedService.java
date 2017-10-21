package devutility.internal.test.service.basic.nio.FileChannel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class CompareReadSpeedService extends BaseService {
	@Override
	public void run() {
		String filename = "D:\\Softwares\\Java\\eclipse-jee-oxygen-R-win32-x86_64.zip";
		useMappedByteBuffer(filename);
		useByteBuffer(filename);
	}

	private void useMappedByteBuffer(String filename) {
		try (RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw"); FileChannel fileChannel = randomAccessFile.getChannel()) {
			long timeBegin = System.currentTimeMillis();
			fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, randomAccessFile.length());
			long timeEnd = System.currentTimeMillis();

			String message = String.format("Read time: %d ms", (timeEnd - timeBegin));
			println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void useByteBuffer(String filename) {
		try (RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw"); FileChannel fileChannel = randomAccessFile.getChannel()) {
			long timeBegin = System.currentTimeMillis();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) randomAccessFile.length());
			byteBuffer.clear();
			fileChannel.read(byteBuffer);
			long timeEnd = System.currentTimeMillis();

			String message = String.format("Read time: %d ms", (timeEnd - timeBegin));
			println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServiceExecutor.run(CompareReadSpeedService.class);
	}
}