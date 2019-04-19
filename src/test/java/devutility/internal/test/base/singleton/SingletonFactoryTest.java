package devutility.internal.test.base.singleton;

import devutility.internal.base.SingletonFactory;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.data.model.Person;

public class SingletonFactoryTest extends BaseTest {
	@Override
	public void run() {
		Person person = SingletonFactory.create(Person.class);

		if (person == null) {
			println("Null!");
		}
	}

	public static void main(String[] args) {
		TestExecutor.concurrentRun(100, SingletonFactoryTest.class, (data) -> {
			System.out.println(data);
		});
	}
}