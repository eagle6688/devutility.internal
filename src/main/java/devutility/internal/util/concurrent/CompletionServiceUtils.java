package devutility.internal.util.concurrent;

import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class CompletionServiceUtils {
	/**
	 * Create a CompletionService instance
	 * @return {@code CompletionService<V>}
	 */
	public static <V> CompletionService<V> instance() {
		ExecutorService executorService = ExecutorServiceUtils.threadPoolExecutor();
		return new ExecutorCompletionService<>(executorService);
	}

	/**
	 * Run a list of Runnable object
	 * @param runnables: Runnable list
	 * @throws InterruptedException
	 */
	public static <V> void run(List<Runnable> runnables) throws InterruptedException {
		if (runnables == null) {
			return;
		}

		CompletionService<Void> completionService = instance();

		for (Runnable runnable : runnables) {
			completionService.submit(runnable, null);
		}

		int index = 0;

		while (index < runnables.size()) {
			completionService.take();
			index++;
		}

		ExecutorServiceUtils.threadPoolExecutor().shutdown();
		ExecutorServiceUtils.threadPoolExecutor().awaitTermination(0, TimeUnit.SECONDS);
	}
}