package devutility.internal.executors.basic.nio.FileChannel;

import devutility.internal.service.basic.nio.FileChannel.CompareReadSpeedService;
import devutility.internal.test.ServiceExecutor;

public class CompareReadSpeedTest {
	public static void main(String[] args) {
		ServiceExecutor.run(new CompareReadSpeedService());
	}
}