package devutility.internal.lang.classutils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import devutility.internal.lang.ClassUtils;
import devutility.internal.model.Member;
import devutility.internal.model.ObjectField;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

/**
 * 
 * SetterTest
 * 
 * @author: Aldwin Su
 * @version: 2020-11-11 17:20:02
 */
public class SetterTest extends BaseTest {
	@Override
	public void run() {
		Member member = new Member();
		member.setName("ASD");
		println(member.toString());
		List<ObjectField> objectFields = ClassUtils.getEntityFields(Member.class);

		for (ObjectField objectField : objectFields) {
			Field field = objectField.getField();

			if ("name".equals(field.getName())) {
				try {
					Object[] args = { null };
					objectField.getSetter().invoke(member, args);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

		println(member.toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(SetterTest.class);
	}
}