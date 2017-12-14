package devutility.internal.test.service.base.singleton;

import devutility.internal.base.SingletonFactory;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Person;

public class SingletonFactoryTest extends BaseTest {
	@Override
	public void run() {
		Person person = SingletonFactory.create(Person.class);

		if (person == null) {
			println("Null!");
		}

		// println(String.format("The size of container %d", SingletonFactory.container.keySet().size()));
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			TestExecutor.concurrentRun(SingletonFactoryTest.class);
		}
	}
}