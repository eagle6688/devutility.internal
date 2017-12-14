package devutility.internal.test;

import devutility.internal.base.InstanceHelper;

public class TestExecutor {
	// region run

	public static void run(BaseTest test) {
		if (test == null) {
			return;
		}

		printStartMessage(test.getClass());
		test.run();
		printEndMessage(test.getClass());
	}

	public static <T extends BaseTest> void run(Class<T> cl) {
		long startTime = System.currentTimeMillis();

		if (cl == null) {
			return;
		}

		T instance;

		try {
			instance = cl.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return;
		}

		if (InstanceHelper.notInstanceof(instance, BaseTest.class)) {
			return;
		}

		printStartMessage(cl);
		instance.run();
		handleEnd(startTime, cl);
	}

	// endregion

	// region concurrent run

	public static <T extends BaseTest> void concurrentRun(Class<T> cl) {
		if (cl == null) {
			return;
		}

		T instance;

		try {
			instance = cl.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return;
		}

		Runnable task = () -> {
			printStartMessage(cl);
			instance.run();
			printEndMessage(cl);
		};

		Thread thread = new Thread(task);
		thread.run();
	}

	// endregion

	// region print start message

	private static void printStartMessage(Class<?> cl) {
		System.out.println(String.format("Start %s:", cl.getSimpleName()));
	}

	// endregion

	// region print end message

	private static void printEndMessage(Class<?> cl) {
		System.out.println(String.format("%s end.", cl.getSimpleName()));
	}

	// endregion

	// region handle end

	private static void handleEnd(long startTime, Class<?> clazz) {
		long endTime = System.currentTimeMillis();
		String message = String.format("%s end, cost %d millisecond.", clazz.getSimpleName(), (endTime - startTime));
		System.out.println(message);
	}

	// endregion
}