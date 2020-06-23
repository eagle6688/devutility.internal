package devutility.internal.basic.util.comparator;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CompareToTest extends BaseTest {
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		println("asd".compareTo("qwe"));

		Long long1 = 1000L;
		Long long2 = 1008L;
		println(long1.compareTo(long2));
		println(long2.compareTo(long1));

		System.out.println(Comparable.class.isAssignableFrom(long1.getClass()));

		@SuppressWarnings("rawtypes")
		Comparable comparableobject1 = (Comparable) long1;

		@SuppressWarnings("rawtypes")
		Comparable comparableobject2 = (Comparable) long2;

		println(comparableobject1.compareTo(comparableobject2));
		println(comparableobject2.compareTo(comparableobject1));
	}

	public static void main(String[] args) {
		TestExecutor.run(CompareToTest.class);
	}
}