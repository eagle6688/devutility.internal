package devutility.internal.util.concurrent;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;

public class CompletionServiceUtils {
	/**
	 * Create a CompletionService instance
	 * @return CompletionService<V>
	 */
	public static <V> CompletionService<V> instance() {
		ExecutorService executorService = ExecutorServiceUtils.threadPoolExecutor();
		return new ExecutorCompletionService<>(executorService);
	}
}