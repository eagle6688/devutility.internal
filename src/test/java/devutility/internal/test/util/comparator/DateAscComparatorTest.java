package devutility.internal.test.util.comparator;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;

import devutility.internal.lang.ClassUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.data.model.Person;
import devutility.internal.util.comparator.ComparatorUtils;

public class DateAscComparatorTest extends BaseTest {
	@Override
	public void run() {
		List<Person> list = Person.list(10);
		list.add(new Person());
		list.add(new Person());

		Method method = ClassUtils.getMethod("getBirthday", Person.class);
		Comparator<Person> comparator = ComparatorUtils.dateAscComparator(method);
		list.sort(comparator);

		list.forEach(i -> {
			System.out.println(i.getBirthday());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(DateAscComparatorTest.class);
	}
}