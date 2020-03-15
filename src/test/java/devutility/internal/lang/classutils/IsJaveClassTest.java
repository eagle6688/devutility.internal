package devutility.internal.lang.classutils;

import java.util.ArrayList;

import devutility.internal.lang.ClassUtils;
import devutility.internal.model.Person;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class IsJaveClassTest extends BaseTest {
	@Override
	public void run() {
		ArrayList<Person> list = new ArrayList<>();
		println(String.format("ArrayList<Person> %s java class!", ClassUtils.isJaveClass(list.getClass()) ? "is" : "is not"));
		println(String.format("Person %s java class!", ClassUtils.isJaveClass(new Person().getClass()) ? "is" : "is not"));
		println(String.format("Object %s java class!", ClassUtils.isJaveClass(new Object().getClass()) ? "is" : "is not"));
	}

	public static void main(String[] args) {
		TestExecutor.run(IsJaveClassTest.class);
	}
}