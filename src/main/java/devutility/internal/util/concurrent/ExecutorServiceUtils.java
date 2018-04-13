package devutility.internal.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import devutility.internal.system.SystemHelper;

public class ExecutorServiceUtils {
	/**
	 * ExecutorServiceHolder
	 */
	private static class ExecutorServiceHolder {
		/**
		 * Processors count for the current machine
		 */
		private static int processorsCount = SystemHelper.getProcessorsCount();

		/**
		 * Default ThreadPoolExecutor object
		 */
		public static ExecutorService executorService = new ThreadPoolExecutor(processorsCount, processorsCount * 5, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), (thread) -> {
			return new Thread(thread);
		});
	}

	/**
	 * Get default ThreadPoolExecutor
	 * @return ExecutorService
	 */
	public static ExecutorService threadPoolExecutor() {
		return ExecutorServiceHolder.executorService;
	}
}