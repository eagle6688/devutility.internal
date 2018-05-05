package devutility.internal.test.service.lang.classhelper;

import java.util.Arrays;
import java.util.List;

import devutility.internal.lang.ClassHelper;
import devutility.internal.lang.models.EntityField;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Student;

public class GetEntityFieldsTest extends BaseTest {
	@Override
	public void run() {
		List<EntityField> list = ClassHelper.getEntityFields(Student.class);

		list.forEach(i -> {
			println(i.getField().getName());
		});

		println("========================================");
		list = ClassHelper.getNonExcludedEntityFields(Arrays.asList("age"), Student.class);

		list.forEach(i -> {
			println(i.getField().getName());
		});

		println("========================================");
		list = ClassHelper.getIncludedEntityFields(Arrays.asList("age"), Student.class);

		list.forEach(i -> {
			println(i.getField().getName());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(GetEntityFieldsTest.class);
	}
}