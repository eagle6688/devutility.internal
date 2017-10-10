package devutility.internal.executors.basic.lang;

import devutility.internal.service.basic.nio.ByteBufferService;
import devutility.internal.test.ServiceExecutor;

public class ByteBufferTest {
	public static void main(String[] args) {
		ServiceExecutor.run(new ByteBufferService());
	}
}