package devutility.internal.test.service.basic.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CallableFutureTest extends BaseTest {
	@Override
	public void run() {
		Callable<Integer> callable = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("Callable task starts...");
				Thread.sleep(1000);
				int result = 0;

				for (int i = 0; i < 100; i++) {
					result += i;
				}

				System.out.println("Callable task finished and return result.");
				return result;
			}
		};

		FutureTask<Integer> future = new FutureTask<>(callable);
		new Thread(future).start();

		try {
			println("Before task execute...");
			int result = future.get();
			println(String.format("Result: %d", result));
			println("After task executed.");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(CallableFutureTest.class);
	}
}