package devutility.internal.test.service.basic.util.stream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Person;
import devutility.internal.text.format.DateFormatHelper;

/**
 * This is also a Comparator example
 * CollectionsTest
 * @author: Lenovo 
 * @date:   2018-02-12 15:24:25  
 * @Copyright: 2018 www.lenovo.com Inc. All rights reserved.
 */
public class CollectionsTest extends BaseTest {
	@Override
	public void run() {
		SimpleDateFormat simpleDateFormat = DateFormatHelper.getSimpleDateFormat("yyyy-MM-dd");
		List<Person> persons = new ArrayList<>();

		try {
			persons.add(new Person("Aldwin", 29, simpleDateFormat.parse("1979-1-2")));
			persons.add(new Person("James", 49, simpleDateFormat.parse("1989-1-2")));
			persons.add(new Person("Sandeep", 39, simpleDateFormat.parse("1990-1-2")));
			persons.add(new Person("Sandeep", 19, simpleDateFormat.parse("1990-1-2")));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		sortName1(persons);
		sortName2(persons);
		sortName3(persons);
		sortName4(persons);
		sortAge1(persons);
		sortAge2(persons);
		sortBirthday1(persons);
		sortBirthday2(persons);
		sortMultiple1(persons);
		sortMultiple2(persons);
	}

	// asc
	private void sortName1(List<Person> persons) {
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.compareTo(o2);
			}
		});

		println("name asc:");
		System.out.println(persons);
	}

	// reversed
	private void sortName2(List<Person> persons) {
		persons.sort((p1, p2) -> p2.getName().compareTo(p1.getName()));
		println("name reversed:");
		System.out.println(persons);
	}

	// asc
	private void sortName3(List<Person> persons) {
		Comparator<Person> comparator = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.compareTo(o2);
			}
		};

		Collections.sort(persons, comparator);
		println("name asc:");
		System.out.println(persons);
	}

	// reversed
	private void sortName4(List<Person> persons) {
		Comparator<Person> comparator = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};

		persons.sort(comparator.reversed());
		println("name reversed:");
		System.out.println(persons);
	}

	// age asc
	private void sortAge1(List<Person> persons) {
		persons.sort(Person::compareByAge);
		println("age asc:");
		System.out.println(persons);
	}

	// age reversed recommended
	private void sortAge2(List<Person> persons) {
		persons.sort(Comparator.comparingInt(Person::getAge).reversed());
		println("age reversed recommended:");
		System.out.println(persons);
	}

	// birthday asc
	private void sortBirthday1(List<Person> persons) {
		persons.sort((b1, b2) -> b1.getBirthday().compareTo(b2.getBirthday()));
		println("birthday asc:");
		System.out.println(persons);
	}

	// birthday reversed recommended
	private void sortBirthday2(List<Person> persons) {
		persons.sort(Comparator.comparing(Person::getBirthday, (b1, b2) -> {
			return b1.compareTo(b2);
		}).reversed());

		println("birthday reversed recommended:");
		System.out.println(persons);
	}

	private void sortMultiple1(List<Person> persons) {
		persons.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
		println("multiple sort recommended:");
		System.out.println(persons);
	}

	private void sortMultiple2(List<Person> persons) {
		persons.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge, (a1, a2) -> {
			return a2 - a1;
		}));

		println("multiple sort recommended:");
		System.out.println(persons);
	}

	public static void main(String[] args) {
		TestExecutor.run(CollectionsTest.class);
	}
}