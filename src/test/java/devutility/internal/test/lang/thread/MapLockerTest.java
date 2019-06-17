package devutility.internal.test.lang.thread;

import java.util.concurrent.ConcurrentHashMap;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class MapLockerTest extends BaseTest {
	private static String lockerName = "asd";
	private static ConcurrentHashMap<String, Object> lockers = new ConcurrentHashMap<>();

	@Override
	public void run() {
		Thread thread1 = new Thread(() -> {
			System.out.println("Thread1 are running...");
			long milliseconds = System.currentTimeMillis();

			lockProcess2();

			System.out.println(String.format("Thread1 finished, cost: %d", System.currentTimeMillis() - milliseconds));
		});

		thread1.setName("Thread1");

		Thread thread2 = new Thread(() -> {
			System.out.println("Thread2 are running...");
			long milliseconds = System.currentTimeMillis();

			lockProcess2();

			System.out.println(String.format("Thread2 finished, cost: %d", System.currentTimeMillis() - milliseconds));
		});

		thread2.setName("Thread2");

		thread1.start();
		thread2.start();
	}

	void lockProcess1() {
		Object locker = lockers.get(lockerName);

		if (locker == null) {
			return;
		}

		synchronized (locker) {
			System.out.println(String.format("%s get locker!", Thread.currentThread().getName()));

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	void lockProcess2() {
		Object locker = lockers.get(lockerName);

		if (locker == null) {
			locker = new Object();
			lockers.put(lockerName, locker);
		}

		synchronized (locker) {
			System.out.println(String.format("%s get locker!", Thread.currentThread().getName()));

			if (lockers.get(lockerName) == null) {
				return;
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			lockers.remove(lockerName);
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(MapLockerTest.class);
	}
}