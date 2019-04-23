package devutility.internal.test.data.model;

import java.util.LinkedList;
import java.util.List;

import devutility.internal.util.RandomUtils;

/**
 * 
 * Member
 * 
 * @author: Aldwin Su
 * @version: 2019-04-14 13:00:11
 */
public class Member {
	private int id;
	private String value;
	private String name;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	public static List<Member> list(int count) {
		List<Member> list = new LinkedList<>();

		for (int i = 0; i < count; i++) {
			Member member = new Member();
			member.setId(i + 1);
			member.setName(String.format("Name%d", i + 1));
			member.setAge(RandomUtils.getNumber(10, 50));
			list.add(member);
		}

		return list;
	}

	public String compareValue() {
		return String.format("%s%s%d", this.getName(), this.getValue(), this.getAge());
	}

	@Override
	public boolean equals(Object obj) {
		Member member = (Member) obj;

		if (this == member) {
			return true;
		}

		if (member == null) {
			return false;
		}

		return this.compareValue().equals(member.compareValue());
	}
}