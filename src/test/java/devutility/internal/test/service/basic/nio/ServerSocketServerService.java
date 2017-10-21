package devutility.internal.test.service.basic.nio;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

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
				String clientName = clientAddress.toString();
				System.out.println("Handling client at " + clientName);

				try (InputStream inputStream = socket.getInputStream()) {
					while ((readBytesCount = inputStream.read(bytesBuffer)) != -1) {
						byte[] temp = new byte[readBytesCount];
						System.arraycopy(bytesBuffer, 0, temp, 0, readBytesCount);
						String message = String.format("%s message: %s", clientName, new String(temp));
						println(message);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServiceExecutor.run(new ServerSocketServerService());
	}
}