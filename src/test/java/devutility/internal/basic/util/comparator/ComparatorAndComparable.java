package devutility.internal.basic.util.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import devutility.internal.model.Person;

public class ComparatorAndComparable {
	public static void main(String[] args) {
		List<Person> persons = getPersons();
		System.out.println("Original sort:");
		displayPersons(persons);

		sortPersons(persons);
		System.out.println("Sort by name:");
		displayPersons(persons);

		sortPersonByAgeAsc(persons);
		System.out.println("Sort by age asc:");
		displayPersons(persons);

		sortPersonByAgeDesc(persons);
		System.out.println("Sort by age desc:");
		displayPersons(persons);
	}

	static List<Person> getPersons() {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("ccc", 20));
		list.add(new Person("AAA", 30));
		list.add(new Person("bbb", 10));
		list.add(new Person("ddd", 40));
		return list;
	}

	static void sortPersons(List<Person> persons) {
		Collections.sort(persons);
	}

	static void sortPersonByAgeAsc(List<Person> persons) {
		Collections.sort(persons, new AscAgeComparator());
	}

	static void sortPersonByAgeDesc(List<Person> persons) {
		Collections.sort(persons, new DescAgeComparator());
	}

	static void displayPersons(List<Person> persons) {
		persons.stream().forEach(i -> {
			System.out.println(String.format("name: %s, age: %d", i.getName(), i.getAge()));
		});
	}
}

class AscAgeComparator implements Comparator<Person> {
	@Override
	public int compare(Person person1, Person person2) {
		return person1.getAge() - person2.getAge();
	}
}

class DescAgeComparator implements Comparator<Person> {
	@Override
	public int compare(Person person1, Person person2) {
		return person2.getAge() - person1.getAge();
	}
}