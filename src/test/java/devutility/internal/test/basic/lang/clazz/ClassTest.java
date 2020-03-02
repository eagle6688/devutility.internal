package devutility.internal.test.basic.lang.clazz;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.model.Student;

public class ClassTest extends BaseTest {
	Student student = new Student();

	@Override
	public void run() {
		Class<?> studentClass = student.getClass();
		println(studentClass == Student.class ? "studentClass==Student.class" : "class1!=Student.class");
		println(String.format("studentClass.getCanonicalName(): %s", studentClass.getCanonicalName()));
		println(String.format("studentClass.getSimpleName(): %s", studentClass.getSimpleName()));
		println(String.format("studentClass.getTypeName(): %s", studentClass.getTypeName()));
		println(String.format("studentClass.getName(): %s", studentClass.getName()));
		println(String.format("studentClass.toString(): %s", studentClass.toString()));
		println(String.format("studentClass.toGenericString(): %s", studentClass.toGenericString()));
		println(studentClass.isPrimitive() ? "studentClass is Primitive" : "studentClass is not Primitive");

		Class<?> intClass = int.class;
		println(intClass.isPrimitive() ? "int is Primitive" : "int is not Primitive");
		println(intClass == Integer.class ? "intClass==Integer.class" : "intClass!=Integer.class");

		Class<String[]> arrayClass = String[].class;
		println(String.format("arrayClass.isArray(): %s", arrayClass.isArray()));
		println(String.format("arrayClass.getCanonicalName(): %s", arrayClass.getCanonicalName()));
		println(String.format("arrayClass.getSimpleName(): %s", arrayClass.getSimpleName()));
		println(String.format("arrayClass.getTypeName(): %s", arrayClass.getTypeName()));
		println(String.format("arrayClass.getName(): %s", arrayClass.getName()));
		println(String.format("arrayClass.toString(): %s", arrayClass.toString()));
		println(String.format("arrayClass.toGenericString(): %s", arrayClass.toGenericString()));

		Class<?> componentType = arrayClass.getComponentType();
		println(String.format("componentType.getCanonicalName(): %s", componentType.getCanonicalName()));

		String str = "asd";
		Object object = str;
		Class<?> objectClass = object.getClass();
		println(String.format("objectClass.getCanonicalName(): %s", objectClass.getCanonicalName()));
	}

	public static void main(String[] args) {
		TestExecutor.run(ClassTest.class);
	}
}