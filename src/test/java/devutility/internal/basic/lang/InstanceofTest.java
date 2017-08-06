package devutility.internal.basic.lang;

import devutility.internal.models.*;

public class InstanceofTest {
	public static void main(String[] args) {
		Person person = new Person();

		if (person instanceof Person) {
			System.out.println("Object person is instance of class Person.");
		}

		if (person instanceof Student) {
			System.out.println("Object person is instance of class Student.");
		}

		if (person instanceof Postgraduate) {
			System.out.println("Object person is instance of class Postgraduate.");
		}

		Student student = new Student();

		if (student instanceof Person) {
			System.out.println("Object student is instance of class Person.");
		}

		if (student instanceof Student) {
			System.out.println("Object student is instance of class Student.");
		}

		if (student instanceof Postgraduate) {
			System.out.println("Object student is instance of class Postgraduate.");
		}

		Postgraduate postgraduate = new Postgraduate();
		
		if (postgraduate instanceof Person) {
			System.out.println("Object postgraduate is instance of class Person.");
		}

		if (postgraduate instanceof Student) {
			System.out.println("Object postgraduate is instance of class Student.");
		}

		if (postgraduate instanceof Postgraduate) {
			System.out.println("Object postgraduate is instance of class Postgraduate.");
		}
	}
}