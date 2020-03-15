package devutility.internal.basic.nio.filechannel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GatherService extends BaseTest {
	@Override
	public void run() {
		String filename = "E:\\Downloads\\Test.txt";
		ByteBuffer headerBytes = ByteBuffer.wrap("Hello".getBytes());
		ByteBuffer bodyBytes = ByteBuffer.wrap("World!".getBytes());
		ByteBuffer[] byteBuffers = new ByteBuffer[] { headerBytes, bodyBytes };

		try (FileOutputStream fileOutputStream = new FileOutputStream(filename); FileChannel fileChannel = fileOutputStream.getChannel()) {
			fileChannel.write(byteBuffers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestExecutor.run(GatherService.class);
	}
}