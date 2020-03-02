package devutility.internal.test.lang.classutils;

import java.util.List;

import devutility.internal.lang.ClassUtils;
import devutility.internal.lang.models.EntityField;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.model.Member;

public class GetEntityFieldsWithOrderTest extends BaseTest {
	@Override
	public void run() {
		List<EntityField> list = ClassUtils.getEntityFields(Member.class);

		list.forEach(i -> {
			println(i.getField().getName());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(GetEntityFieldsWithOrderTest.class);
	}
}