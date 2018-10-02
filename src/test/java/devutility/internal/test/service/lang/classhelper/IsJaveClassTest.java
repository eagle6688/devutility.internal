package devutility.internal.test.service.lang.classhelper;

import java.util.ArrayList;

import devutility.internal.lang.ClassUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Person;

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