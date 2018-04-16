package devutility.internal.test.service.base.singleton;

import devutility.internal.base.SingletonFactory;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Person;

public class SingletonFactoryTest extends BaseTest {
	@Override
	public void run() {
		Person person = SingletonFactory.get(Person.class);

		if (person == null) {
			println("Null!");
		}

		println(String.format("The size of container %d", SingletonFactory.getContainer().size()));
	}

	public static void main(String[] args) {
		TestExecutor.concurrentRun(100, SingletonFactoryTest.class, (data) -> {
			System.out.println(data);
		});
	}
}