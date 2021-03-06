package devutility.internal.lang.classutils;

import java.util.List;

import devutility.internal.lang.ClassUtils;
import devutility.internal.model.ObjectField;
import devutility.internal.model.Member;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetEntityFieldsWithOrderTest extends BaseTest {
	@Override
	public void run() {
		List<ObjectField> list = ClassUtils.getEntityFields(Member.class);

		list.forEach(i -> {
			println(i.getField().getName());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(GetEntityFieldsWithOrderTest.class);
	}
}