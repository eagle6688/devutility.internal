package devutility.internal.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import devutility.internal.lang.ClassUtils;
import devutility.internal.util.concurrent.CompletionServiceUtils;
import devutility.internal.util.concurrent.ExecutorServiceUtils;

/**
 * 
 * TestExecutor
 * 
 * @author: Aldwin Su
 */
public class TestExecutor {
	/**
	 * Run BaseTest instance
	 * @param instance BaseTest instance
	 */
	public static void run(BaseTest instance) {
		if (instance == null) {
			return;
		}

		preExecute(instance.getClass());

		long startTime = System.currentTimeMillis();
		instance.run();

		postExecute(startTime, instance.getClass());
	}

	/**
	 * Create a BaseTest instance and run it.
	 * @param clazz BaseTest instance
	 */
	public static <T extends BaseTest> void run(Class<T> clazz) {
		if (clazz == null) {
			return;
		}

		T instance = ClassUtils.instance(clazz);

		if (instance == null) {
			System.out.println("Create new instance failed!");
			return;
		}

		preExecute(clazz);

		long startTime = System.currentTimeMillis();
		instance.run();

		postExecute(startTime, clazz);
	}

	/**
	 * Create a BaseTest instance and concurrently run it.
	 * @param clazz BaseTest instance
	 */
	public static <T extends BaseTest> void concurrentRun(Class<T> clazz) {
		if (clazz == null) {
			return;
		}

		T instance = ClassUtils.instance(clazz);

		if (instance == null) {
			return;
		}

		Runnable task = () -> {
			preExecute(clazz);

			long startTime = System.currentTimeMillis();
			instance.run();

			postExecute(startTime, clazz);
		};

		ExecutorServiceUtils.threadPoolExecutor().execute(task);
	}

	/**
	 * Running instance list concurrently.
	 * @param instances Instance list
	 * @param clazz BaseTest instance
	 */
	public static <T extends BaseTest> void concurrentRun(List<T> instances, Class<T> clazz) {
		concurrentRun(instances, clazz, null);
	}

	/**
	 * Running {@code count} instances with class {@code clazz} concurrently.
	 * @param count The amount of instances.
	 * @param clazz BaseTest instance
	 * @param callback
	 */
	public static <T extends BaseTest> void concurrentRun(int count, Class<T> clazz, Callback callback) {
		if (count <= 0 || clazz == null) {
			return;
		}

		List<T> instances = new ArrayList<>(count);

		for (int i = 0; i < count; i++) {
			T instance = ClassUtils.instance(clazz);
			instances.add(instance);
		}

		concurrentRun(instances, clazz, callback);
	}

	/**
	 * Running instances concurrently.
	 * @param instances Instance list
	 * @param clazz BaseTest instance
	 * @param callback
	 */
	public static <T extends BaseTest> void concurrentRun(List<T> instances, Class<T> clazz, Callback callback) {
		if (instances == null || clazz == null) {
			return;
		}

		AtomicInteger counter = new AtomicInteger(0);
		List<Runnable> tasks = new ArrayList<>(instances.size());

		for (T instance : instances) {
			tasks.add(() -> {
				preExecute(clazz);

				long startTime = System.currentTimeMillis();
				instance.run();

				postExecute(startTime, clazz);
				counter.addAndGet(1);
			});
		}

		try {
			CompletionServiceUtils.run(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (callback != null) {
			callback.execute(counter);
		}
	}

	/**
	 * Event pre execute
	 * @param clazz Class of executing object.
	 */
	private static void preExecute(Class<?> clazz) {
		System.out.println(String.format("Start executing %s:", clazz.getSimpleName()));
	}

	/**
	 * Post execute
	 * @param startTime Start time of execution.
	 * @param clazz Class of executing object.
	 */
	private static void postExecute(long startTime, Class<?> clazz) {
		long endTime = System.currentTimeMillis();
		String message = String.format("Executing %s end, cost %d millisecond.", clazz.getSimpleName(), (endTime - startTime));
		System.out.println(message);
	}
}