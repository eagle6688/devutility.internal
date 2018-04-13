package devutility.internal.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import devutility.internal.base.Callback;
import devutility.internal.lang.ClassHelper;
import devutility.internal.util.concurrent.ExecutorServiceUtils;

public class TestExecutor {
	/**
	 * Run BaseTest instance
	 * @param instance: BaseTest instance
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
	 * @param clazz: BaseTest instance
	 */
	public static <T extends BaseTest> void run(Class<T> clazz) {
		if (clazz == null) {
			return;
		}

		T instance = ClassHelper.newInstance(clazz);

		if (!ClassHelper.isInstanceOf(instance, BaseTest.class)) {
			return;
		}

		preExecute(clazz);

		long startTime = System.currentTimeMillis();
		instance.run();

		postExecute(startTime, clazz);
	}

	/**
	 * Create a BaseTest instance and concurrently run it.
	 * @param clazz: BaseTest instance
	 */
	public static <T extends BaseTest> void concurrentRun(Class<T> clazz) {
		if (clazz == null) {
			return;
		}

		T instance = ClassHelper.newInstance(clazz);

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
				counter.addAndGet(1);

				postExecute(startTime, clazz);
			});
		}

		if (callback != null) {
			callback.execute(counter);
		}
	}

	/**
	 * Event pre execute
	 * @param clazz: Class of executing object.
	 */
	private static void preExecute(Class<?> clazz) {
		System.out.println(String.format("Start executing  %s:", clazz.getSimpleName()));
	}

	/**
	 * Post execute
	 * @param startTime: Start time of execution.
	 * @param clazz: Class of executing object.
	 */
	private static void postExecute(long startTime, Class<?> clazz) {
		long endTime = System.currentTimeMillis();
		String message = String.format("Executing %s end, cost %d millisecond.", clazz.getSimpleName(), (endTime - startTime));
		System.out.println(message);
	}
}