package devutility.internal.nio.rafu;

import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;

import devutility.internal.nio.RandomAccessFileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class AsyncAppendTest extends BaseTest {
	String fileName = "E:\\Downloads\\Test.txt";

	@Override
	public void run() {
		ByteBuffer byteBuffer = ByteBuffer.wrap("Hello Lenovo!".getBytes());
		
		try {
			RandomAccessFileUtils.asyncAppend(fileName, byteBuffer);
			
			byteBuffer.flip();
			
			RandomAccessFileUtils.asyncAppend(fileName, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
				@Override
				public void completed(Integer result, ByteBuffer attachment) {
					println("bytes written: " + result);
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					println("Write failed!");
					exc.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		println("OK!");
	}
	
	public static void main(String[] args) {
		TestExecutor.run(new AsyncAppendTest());
	}
}