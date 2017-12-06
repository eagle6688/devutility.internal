package devutility.internal.test.service.base.singleton;

import devutility.internal.base.SingletonFactory;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;
import devutility.internal.test.models.Person;

public class SingletonFactoryTest extends BaseService {
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
			ServiceExecutor.concurrentRun(SingletonFactoryTest.class);
		}
	}
}