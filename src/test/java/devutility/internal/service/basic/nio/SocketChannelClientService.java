package devutility.internal.service.basic.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

import devutility.internal.test.BaseService;

public class SocketChannelClientService extends BaseService {
	@Override
	public void run() {
		client();
	}

	private void client() {
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

		try (SocketChannel socketChannel = SocketChannel.open()) {
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("127.0.0.1", 8091));

			if (socketChannel.finishConnect()) {
				int i = 0;

				while (true) {
					TimeUnit.SECONDS.sleep(1);
					String message = String.format("I'm %d-th message from client.", i);

					byteBuffer.clear();
					byteBuffer.put(message.getBytes());
					byteBuffer.flip();

					while (byteBuffer.hasRemaining()) {
						System.out.println(byteBuffer);
						socketChannel.write(byteBuffer);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}