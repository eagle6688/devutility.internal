package devutility.internal.data.converter;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import devutility.internal.data.BeanUtils;
import devutility.internal.lang.ClassUtils;
import devutility.internal.model.ObjectField;
import devutility.internal.model.Person;
import devutility.internal.model.constant.Gender;
import devutility.internal.model.converter.GenderConverter;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ConverterTest extends BaseTest {
	@Override
	public void run() {
		List<ObjectField> entityFields = ClassUtils.getEntityFields(Person.class);
		Person person = Person.get();
		person.setGender(Gender.FEMALE);

		ConverterCacheUtils.register(new GenderConverter());

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
		TestExecutor.run(ConverterTest.class);
	}
}