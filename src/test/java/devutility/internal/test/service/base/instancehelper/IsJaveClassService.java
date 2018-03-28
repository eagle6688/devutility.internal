package devutility.internal.test.service.base.instancehelper;

import java.util.ArrayList;

import devutility.internal.base.InstanceHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Person;

public class IsJaveClassService extends BaseTest {
	@Override
	public void run() {
		ArrayList<Person> list = new ArrayList<>();
		println(String.format("ArrayList<Person> %s java class!", InstanceHelper.isJaveClass(list.getClass()) ? "is" : "is not"));
		println(String.format("Person %s java class!", InstanceHelper.isJaveClass(new Person().getClass()) ? "is" : "is not"));
		println(String.format("Object %s java class!", InstanceHelper.isJaveClass(new Object().getClass()) ? "is" : "is not"));
	}

	public static void main(String[] args) {
		TestExecutor.run(IsJaveClassService.class);
	}
}