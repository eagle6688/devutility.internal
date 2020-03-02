package devutility.internal.test.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import devutility.internal.data.converter.ConverterUtils;
import devutility.internal.test.model.constant.Gender;
import devutility.internal.util.RandomUtils;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private Date birthday;
	private boolean local;
	private Gender gender;

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public static Person get() {
		List<Person> persons = list(1);
		return persons.get(0);
	}

	public static List<Person> list(int count) {
		List<Person> list = new ArrayList<>(count);
		LocalDate localDate = LocalDate.now();
		int currentYear = localDate.getYear();

		for (int i = 0; i < count; i++) {
			Person person = new Person();
			int year = RandomUtils.getNumber(currentYear - count, currentYear);
			int month = RandomUtils.getNumber(1, 12);
			int day = RandomUtils.getNumber(1, 28);
			person.setBirthday(ConverterUtils.localDateToDate(LocalDate.of(year, month, day), null));
			list.add(person);
		}

		return list;
	}
}