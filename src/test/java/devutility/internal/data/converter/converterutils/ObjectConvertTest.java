package devutility.internal.data.converter.converterutils;

import java.io.Serializable;

import devutility.internal.data.converter.ConverterUtils;
import devutility.internal.model.Person;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

/**
 * 
 * ObjectConvertTest, Person and CommonSerializableClass must implements Serializable interface.
 * 
 * @author: Aldwin Su
 * @version: 2020-05-26 16:24:16
 */
public class ObjectConvertTest extends BaseTest {
	@Override
	public void run() {
		Person person = Person.get();
		println(person.toString());

		CommonSerializableClass<Person> commonSerializableClass = new CommonSerializableClass<>(person);
		byte[] bytes = ConverterUtils.objectToBytes(commonSerializableClass);

		@SuppressWarnings("unchecked")
		CommonSerializableClass<Person> newCommonSerializableClass = (CommonSerializableClass<Person>) ConverterUtils.bytesToObject(bytes);
		println(newCommonSerializableClass.getValue().toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(ObjectConvertTest.class);
	}
}

class CommonSerializableClass<T> implements Serializable {
	private static final long serialVersionUID = -7671940727504213673L;

	private T value;

	public CommonSerializableClass() {
	}

	public CommonSerializableClass(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}