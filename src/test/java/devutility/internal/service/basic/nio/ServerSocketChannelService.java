package devutility.internal.service.basic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import devutility.internal.test.BaseService;

public class ServerSocketChannelService extends BaseService {
	private static final int BUF_SIZE = 1024;
	private static final int PORT = 8091;
	private static final int TIMEOUT = 3000;

	@Override
	public void run() {
		try (Selector selector = Selector.open(); ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
			serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			
			while (true) {
				if (selector.select(TIMEOUT) == 0) {
					System.out.println("==");
					continue;
				}
				
				Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
				
				while (iter.hasNext()) {
					SelectionKey key = iter.next();
					if (key.isAcceptable()) {
						handleAccept(key);
					}
					if (key.isReadable()) {
						handleRead(key);
					}
					if (key.isWritable() && key.isValid()) {
						handleWrite(key);
					}
					if (key.isConnectable()) {
						System.out.println("isConnectable = true");
					}
					iter.remove();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void handleAccept(SelectionKey key) throws IOException {
		ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
		SocketChannel socketChannel = serverSocketChannel.accept();
		socketChannel.configureBlocking(false);
		socketChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
	}

	public static void handleRead(SelectionKey key) throws Exception {
		try (SocketChannel socketChannel = (SocketChannel) key.channel()) {
			ByteBuffer byteBuffer = (ByteBuffer) key.attachment();

			while (socketChannel.read(byteBuffer) > -1) {
				byteBuffer.flip();

				while (byteBuffer.hasRemaining()) {
					System.out.print((char) byteBuffer.get());
				}

				System.out.println();
				byteBuffer.clear();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public static void handleWrite(SelectionKey key) throws IOException {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
		byteBuffer.flip();

		while (byteBuffer.hasRemaining()) {
			socketChannel.write(byteBuffer);
		}

		byteBuffer.compact();
	}
}