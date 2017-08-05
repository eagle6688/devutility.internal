package devutility.internal.basic.reflect;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.time.LocalDateTime;

import devutility.internal.models.Student;

public class JavaBeanTest {
	public static void main(String[] args) throws Exception {
		Class<?> cl = Student.class;
		BeanInfo beanInfo = Introspector.getBeanInfo(cl);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		Student student = new Student();
		student.Number = "123";
		student.setAge(29);
		student.setEntryTime(LocalDateTime.now());
		student.setName("Aldwin");

		int index = 0;

		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			System.out.println(index);
			System.out.println(String.format("getName(): %s", propertyDescriptor.getName()));
			System.out.println(String.format("getDisplayName(): %s", propertyDescriptor.getDisplayName()));
			System.out.println(String.format("getPropertyType().getName(): %s", propertyDescriptor.getPropertyType().getName()));
			System.out.println(propertyDescriptor.getReadMethod().invoke(student));
			index++;
		}
	}
}