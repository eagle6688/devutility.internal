package devutility.internal.basic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import devutility.internal.models.Student;

public class ClassTest {
	public static void main(String[] args) throws Exception {
		Student pete = new Student();
		Class<?> class1 = pete.getClass();
		System.out.println(String.format("class1 getCanonicalName: %s", class1.getCanonicalName()));
		System.out.println(String.format("class1 getSimpleName: %s", class1.getSimpleName()));
		System.out.println(String.format("class1 getTypeName: %s", class1.getTypeName()));
		System.out.println(String.format("class1 getName: %s", class1.getName()));
		System.out.println(String.format("class1 toString: %s", class1.toString()));
		System.out.println(String.format("class1 toGenericString: %s", class1.toGenericString()));
		System.out.println(class1.isPrimitive() ? "class1 is Primitive" : "class1 is not Primitive");
		System.out.println(int.class.isPrimitive() ? "int is Primitive" : "int is not Primitive");

		Class<?> class2 = Class.forName(class1.getCanonicalName());
		Object peteObj = class2.newInstance();
		System.out.println(String.format("peteObj getCanonicalName: %s", peteObj.getClass().getCanonicalName()));

		if (peteObj instanceof Student) {
			System.out.println("peteObj is instance of Student!");
		}

		Student pete2 = (Student) class2.newInstance();
		System.out.println(String.format("pete2 getCanonicalName: %s", pete2.getClass().getCanonicalName()));

		Class<?> class3 = Student.class;
		System.out.println(String.format("class3 getCanonicalName: %s", class3.getCanonicalName()));
		System.out.println(String.format("class3 getName: %s", class3.getName()));

		Class<?> class4 = String[].class;
		System.out.println(String.format("class4 getCanonicalName: %s", class4.getCanonicalName()));
		System.out.println(String.format("class4 getSimpleName: %s", class4.getSimpleName()));
		System.out.println(String.format("class4 getTypeName: %s", class4.getTypeName()));
		System.out.println(String.format("class4 getName: %s", class4.getName()));
		System.out.println(String.format("class4 toString: %s", class4.toString()));
		System.out.println(String.format("class4 toGenericString: %s", class4.toGenericString()));

		Field[] fields = class1.getFields();
		System.out.println(fields.length);

		for (Field field : fields) {
			System.out.println(field.getName());
		}

		Field[] declaredFields = class1.getDeclaredFields();
		System.out.println(declaredFields.length);

		for (Field declaredField : declaredFields) {
			System.out.println(declaredField.getName());
		}

		Method[] methods = class1.getMethods();
		System.out.println(methods.length);

		for (Method method : methods) {
			System.out.println(method.getName());
		}

		Method[] declaredMethods = class1.getDeclaredMethods();
		System.out.println(declaredMethods.length);

		for (Method declaredMethod : declaredMethods) {
			System.out.println(declaredMethod.getName());
		}
	}
}