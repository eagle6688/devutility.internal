package devutility.internal.executors.basic.nio.FileChannel;

import devutility.internal.service.basic.nio.FileChannel.GatherService;
import devutility.internal.test.ServiceExecutor;

public class GatherTest {
	public static void main(String[] args) {
		ServiceExecutor.run(new GatherService());
	}
}