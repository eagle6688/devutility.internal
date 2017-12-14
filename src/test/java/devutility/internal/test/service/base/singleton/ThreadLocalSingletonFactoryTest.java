package devutility.internal.test.service.base.singleton;

import devutility.internal.base.ThreadLocalSingletonFactory;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Person;

public class ThreadLocalSingletonFactoryTest extends BaseTest {
	@Override
	public void run() {
		Person person = null;

		try {
			person = ThreadLocalSingletonFactory.create(Person.class);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		if (person == null) {
			println("Null!");
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			TestExecutor.concurrentRun(ThreadLocalSingletonFactoryTest.class);
		}
	}
}