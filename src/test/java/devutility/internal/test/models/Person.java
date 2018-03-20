package devutility.internal.test.models;

import java.util.Date;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private Date birthday;
	private boolean local;

	public Person() {
	}

	public Person(String name, int age) {
		setName(name);
		setAge(age);
	}

	public Person(String name, int age, Date birthday) {
		this(name, age);
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public int compareTo(Person person) {
		return name.compareTo(person.name);
	}

	@Override
	public String toString() {
		return String.format("name: %s, age: %d, birthday: %s", name, age, birthday);
	}

	public static int compareByAge(Person person1, Person person2) {
		return Integer.compare(person1.getAge(), person2.getAge());
	}

	public boolean isLocal() {
		return local;
	}

	public void setLocal(boolean local) {
		this.local = local;
	}
}