package devutility.internal.test.service.basic.reflect;

import devutility.internal.lang.ClassHelper;
import devutility.internal.test.models.Student;

public class ClassTest {
	public static void main(String[] args) throws Exception {
		Student student = new Student();
		Class<?> class1 = student.getClass();
		System.out.println(String.format("class1 getCanonicalName: %s", class1.getCanonicalName()));
		System.out.println(String.format("class1 getSimpleName: %s", class1.getSimpleName()));
		System.out.println(String.format("class1 getTypeName: %s", class1.getTypeName()));
		System.out.println(String.format("class1 getName: %s", class1.getName()));
		System.out.println(String.format("class1 toString: %s", class1.toString()));
		System.out.println(String.format("class1 toGenericString: %s", class1.toGenericString()));
		System.out.println(class1.isPrimitive() ? "class1 is Primitive" : "class1 is not Primitive");
		System.out.println(int.class.isPrimitive() ? "int is Primitive" : "int is not Primitive");

		Class<?> class2 = Class.forName(class1.getCanonicalName());
		Object object = ClassHelper.newInstance(class2);
		System.out.println(String.format("object getCanonicalName: %s", object.getClass().getCanonicalName()));

		if (object instanceof Student) {
			System.out.println("object is instance of Student!");
		}

		Student student2 = (Student) ClassHelper.newInstance(class2);
		System.out.println(String.format("student2 getCanonicalName: %s", student2.getClass().getCanonicalName()));

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
	}
}