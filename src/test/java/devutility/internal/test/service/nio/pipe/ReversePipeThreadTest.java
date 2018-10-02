package devutility.internal.test.service.nio.pipe;

import java.nio.charset.Charset;

import devutility.internal.nio.pipe.ReversePipeThread;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ReversePipeThreadTest extends BaseTest {
	@Override
	public void run() {
		ReversePipeThread reversePipeThread = new ReversePipeThread(System.in, null);

		reversePipeThread.setCallback(buffer -> {
			if (buffer.hasArray()) {
				System.out.format("Read from device: %s\n", new String(buffer.array(), Charset.forName("UTF-8")));
			}
		});

		reversePipeThread.start();

		while (true) {
			Thread.yield();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ReversePipeThreadTest.class);
	}
}