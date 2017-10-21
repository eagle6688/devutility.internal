package devutility.internal.test.service.basic.nio;

import java.nio.ByteBuffer;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class ByteBufferService extends BaseService {
	@Override
	public void run() {
		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
		
		println(String.format("%s value: %d", "capacity", byteBuffer.capacity()));
		displayBuffer(byteBuffer);

		String value = "Hello world!";
		byte[] bytes = value.getBytes();
		byteBuffer.put(bytes);

		displayBuffer(byteBuffer);
		
		println("flip");
		byteBuffer.flip();
		
		displayBuffer(byteBuffer);

		while (byteBuffer.hasRemaining()) {
			println(String.valueOf((char) byteBuffer.get()));
		}

		displayBuffer(byteBuffer);
		
		println("compact");
		byteBuffer.compact();
		
		displayBuffer(byteBuffer);
		
		while (byteBuffer.hasRemaining()) {
			println(String.valueOf((char) byteBuffer.get()));
		}
	}

	private void displayBuffer(ByteBuffer byteBuffer) {
		String position = String.format("%s value: %d", "position", byteBuffer.position());
		println(position);

		String limit = String.format("%s value: %d", "limit", byteBuffer.limit());
		println(limit);
	}
	
	public static void main(String[] args) {
		ServiceExecutor.run(ByteBufferService.class);
	}
}