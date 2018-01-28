package devutility.internal.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import devutility.internal.system.SystemHelper;

/**
 * @Description: ConcurrentHelper
 * @author: Aldwin
 */
public class ConcurrentHelper {
	private static volatile ConcurrentHelper instance;

	private int processorsCount = 1;

	private ExecutorService executorService = null;

	public ConcurrentHelper() {
		processorsCount = SystemHelper.getProcessorsCount();

		executorService = new ThreadPoolExecutor(processorsCount, processorsCount * 2, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), (thread) -> {
			return new Thread(thread);
		});
	}

	public static ConcurrentHelper instance() {
		if (instance != null) {
			return instance;
		}

		synchronized (ConcurrentExecutor.class) {
			if (instance == null) {
				instance = new ConcurrentHelper();
			}
		}

		return instance;
	}

	public ExecutorService getExecutorService() {
		return executorService;
	}
}