package devutility.internal.test.models;

import java.util.Date;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private Date birthday;

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
}