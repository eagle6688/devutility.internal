package devutility.internal.test.basic.lang.clazz;

import devutility.internal.lang.ClassUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.model.Student;

public class ForNameTest extends BaseTest {
	@Override
	public void run() {
		Student student = new Student();
		Class<?> class1 = student.getClass();
		String canonicalName = class1.getCanonicalName();
		println(canonicalName);
		println(class1.getName());
		println(class1.getSimpleName());

		Class<?> class2 = null;

		try {
			class2 = Class.forName(canonicalName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Object object = ClassUtils.instance(class2);
		println(String.format("object getCanonicalName: %s", object.getClass().getCanonicalName()));
		println(object instanceof Student ? "object is instance of Student!" : "object is not instance of Student!");
	}

	public static void main(String[] args) {
		TestExecutor.run(ForNameTest.class);
	}
}