package devutility.internal.test.service.util.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;
import devutility.internal.test.models.Person;
import devutility.internal.util.ListHelper;
import devutility.internal.util.function.PredicateBuilder;

public class PredicateBuilderTest extends BaseService {
	@Override
	public void run() {
		testOrAnd();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(4);
		list.add(1);

		PredicateBuilder<Integer> predicateBuilder = new PredicateBuilder<>();
		predicateBuilder.or(i -> i == 1);
		predicateBuilder.or(i -> i == 2);
		List<Integer> result = ListHelper.list(list, predicateBuilder.getPredicate());
		System.out.println(result);

		int minValue = ListHelper.minInt(list);
		println(minValue);

		int maxValue = ListHelper.maxInt(list);
		println("maxValue");
		println(maxValue);
	}

	private void testOrAnd() {
		List<Person> list = new ArrayList<>();
		list.add(new Person("James", 30));
		list.add(new Person("Susan", 30));
		list.add(new Person("Aldwin", 29));
		list.add(new Person("Pete", 50));
		list.add(new Person("Hoken", 40));

		PredicateBuilder<Person> predicateBuilder1 = new PredicateBuilder<Person>();
		PredicateBuilder<Person> predicateBuilder2 = new PredicateBuilder<Person>();

		for (String name : Arrays.asList("s", "win")) {
			predicateBuilder2.or(i -> i.getName() != null && i.getName().toLowerCase().indexOf(name.toLowerCase()) > -1);
		}

		predicateBuilder1.and(i -> i.getAge() == 30);
		List<Person> result = ListHelper.list(list, predicateBuilder1.getPredicate());
		println(result.size());
	}

	public static void main(String[] args) {
		ServiceExecutor.run(PredicateBuilderTest.class);
	}
}