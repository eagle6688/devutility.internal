package devutility.internal.test;

import devutility.internal.base.InstanceHelper;

public class ServiceExecutor {
	public static void run(BaseService service) {
		if (service == null) {
			return;
		}
		
		service.run();
	}

	public static <T extends BaseService> void run(Class<T> cl) throws Exception {
		if (cl == null) {
			return;
		}

		T instance = cl.newInstance();

		if (InstanceHelper.notInstanceof(instance, BaseService.class)) {
			return;
		}

		instance.run();
	}

	public static <T extends BaseService> void concurrentRun(Class<T> cl) throws Exception {
		if (cl == null) {
			return;
		}

		T instance = cl.newInstance();

		Runnable task = () -> {
			instance.run();
		};

		Thread thread = new Thread(task);
		thread.run();
	}
}