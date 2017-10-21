package devutility.internal.test;

import devutility.internal.base.InstanceHelper;

public class ServiceExecutor {
	public static void run(BaseService service) {
		if (service == null) {
			return;
		}

		printStartMessage(service.getClass());
		service.run();
		printEndMessage(service.getClass());
	}

	public static <T extends BaseService> void run(Class<T> cl) {
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

		if (InstanceHelper.notInstanceof(instance, BaseService.class)) {
			return;
		}

		printStartMessage(cl);
		instance.run();
		printEndMessage(cl);
	}

	public static <T extends BaseService> void concurrentRun(Class<T> cl) {
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

	private static void printStartMessage(Class<?> cl) {
		System.out.println(String.format("Start %s:", cl.getSimpleName()));
	}

	private static void printEndMessage(Class<?> cl) {
		System.out.println(String.format("%s end.", cl.getSimpleName()));
	}
}