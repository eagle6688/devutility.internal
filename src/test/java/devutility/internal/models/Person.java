package devutility.internal.models;

import java.time.LocalDateTime;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private LocalDateTime birthday;

	public Person() {}
	
	public Person(String name, int age) {
		setName(name);
	    setAge(age);
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
    
    public LocalDateTime getBirthday() {
		return birthday;
	}
    
    public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public int compareTo(Person person) {
		return name.compareTo(person.name);
	}
}