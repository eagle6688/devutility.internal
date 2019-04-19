package devutility.internal.test.data.converter;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import devutility.internal.data.BeanUtils;
import devutility.internal.lang.ClassUtils;
import devutility.internal.lang.models.EntityField;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.data.constants.Gender;
import devutility.internal.test.data.model.Person;

public class ConvertorTest extends BaseTest {
	@Override
	public void run() {
		List<EntityField> entityFields = ClassUtils.getEntityFields(Person.class);
		Person person = Person.get();
		person.setGender(Gender.MALE);

		try {
			String[] array = BeanUtils.toArray(person, entityFields);
			System.out.println(Arrays.toString(array));
			Person who = BeanUtils.toEntity(array, entityFields, Person.class);
			println(who.getGender().toString());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ConvertorTest.class);
	}
}