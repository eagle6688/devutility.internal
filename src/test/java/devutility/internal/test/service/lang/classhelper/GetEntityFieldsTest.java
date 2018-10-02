package devutility.internal.test.service.lang.classhelper;

import java.util.Arrays;
import java.util.List;

import devutility.internal.lang.ClassUtils;
import devutility.internal.lang.models.EntityField;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Student;

public class GetEntityFieldsTest extends BaseTest {
	@Override
	public void run() {
		List<EntityField> list = ClassUtils.getEntityFields(Student.class);

		list.forEach(i -> {
			println(i.getField().getName());
		});

		println("========================================");
		list = ClassUtils.getNonExcludedEntityFields(Arrays.asList("age"), Student.class);

		list.forEach(i -> {
			println(i.getField().getName());
		});

		println("========================================");
		list = ClassUtils.getIncludedEntityFields(Arrays.asList("age"), Student.class);

		list.forEach(i -> {
			println(i.getField().getName());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(GetEntityFieldsTest.class);
	}
}