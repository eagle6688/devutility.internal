package devutility.internal.service.basic.nio;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import devutility.internal.test.BaseService;

public class ServerSocketServerService extends BaseService {
	@Override
	public void run() {
		server();
	}

	private void server() {
		try (ServerSocket serverSocket = new ServerSocket(8091)) {
			int readBytesCount = 0;
			byte[] bytesBuffer = new byte[1024];

			while (true) {
				Socket socket = serverSocket.accept();
				SocketAddress clientAddress = socket.getRemoteSocketAddress();
				System.out.println("Handling client at " + clientAddress);

				try (InputStream inputStream = socket.getInputStream()) {
					while ((readBytesCount = inputStream.read(bytesBuffer)) != -1) {
						byte[] temp = new byte[readBytesCount];
						System.arraycopy(bytesBuffer, 0, temp, 0, readBytesCount);
						System.out.println(new String(temp));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}