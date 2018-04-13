package devutility.internal.util.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConcurrentExecutor {
	/**
	 * Run list of callables, return futures after runing completely.
	 * @param callables: Callable list
	 * @return {@literal: List<Future<R>>}
	 * @throws InterruptedException
	 */
	public static <R> List<Future<R>> run(List<Callable<R>> callables) throws InterruptedException {
		ExecutorService executorService = ExecutorServiceUtils.threadPoolExecutor();

		if (executorService == null) {
			return new ArrayList<>();
		}

		return executorService.invokeAll(callables);
	}

	/**
	 * Run callables and return their results.
	 * @param callables: Callable list
	 * @return {@literal: List<R>}
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static <R> List<R> runAndGet(List<Callable<R>> callables) throws InterruptedException, ExecutionException {
		List<R> list = new ArrayList<>(callables.size());
		List<Future<R>> futures = run(callables);

		for (Future<R> future : futures) {
			list.add(future.get());
		}

		return list;
	}
}