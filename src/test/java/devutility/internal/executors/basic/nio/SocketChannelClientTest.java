package devutility.internal.executors.basic.nio;

import devutility.internal.service.basic.nio.SocketChannelClientService;
import devutility.internal.test.ServiceExecutor;

public class SocketChannelClientTest {
	public static void main(String[] args) {
		ServiceExecutor.run(new SocketChannelClientService());
	}
}