package devutility.internal.executors.basic.nio.FileChannel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import devutility.internal.test.BaseService;

public class AppendContentService extends BaseService {
	String fileName = "E:\\Downloads\\Test.txt";
	
	@Override
	public void run() {
		ByteBuffer headerBytes = ByteBuffer.wrap("Hello".getBytes());
		ByteBuffer bodyBytes = ByteBuffer.wrap("World!".getBytes());
		ByteBuffer[] byteBuffers = new ByteBuffer[] { headerBytes, bodyBytes };

		try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw"); FileChannel fileChannel = randomAccessFile.getChannel()) {
			fileChannel.position(randomAccessFile.length());
			fileChannel.write(byteBuffers);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}