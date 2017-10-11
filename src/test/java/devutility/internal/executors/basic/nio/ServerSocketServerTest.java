package devutility.internal.executors.basic.nio;

import devutility.internal.service.basic.nio.ServerSocketServerService;
import devutility.internal.test.ServiceExecutor;

public class ServerSocketServerTest {
	public static void main(String[] args) {
		ServiceExecutor.run(new ServerSocketServerService());
	}
}