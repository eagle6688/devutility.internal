package devutility.internal.util.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

import devutility.internal.system.SystemHelper;

public class ConcurrentExecutor {
	private static volatile ConcurrentExecutor instance;
	private int processorsCount = 1;
	private ExecutorService executorService = null;

	public ConcurrentExecutor() {
		processorsCount = SystemHelper.getProcessorsCount();
		executorService = Executors.newFixedThreadPool(processorsCount);
	}

	public static ConcurrentExecutor instance() {
		if (instance != null) {
			return instance;
		}

		synchronized (ConcurrentExecutor.class) {
			if (instance == null) {
				instance = new ConcurrentExecutor();
			}
		}

		return instance;
	}

	public <T, R> List<R> map(List<T> list, Function<? super T, ? extends R> mapper) throws InterruptedException, ExecutionException {
		List<R> resultList = new ArrayList<>();
		List<Callable<List<R>>> tasks = new ArrayList<>();
		int pageSize = list.size() / processorsCount + list.size() % processorsCount;

		for (int i = 0; i < processorsCount; i++) {
			Integer start = i * pageSize;
			int index = start + pageSize;
			Integer end = index > list.size() ? list.size() : index;

			tasks.add(() -> {
				return list.subList(start, end).stream().map(mapper).collect(Collectors.toList());
			});
		}

		List<Future<List<R>>> results = executorService.invokeAll(tasks);

		for (Future<List<R>> result : results) {
			resultList.addAll(result.get());
		}

		return resultList;
	}
}