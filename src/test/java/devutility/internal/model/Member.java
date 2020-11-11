package devutility.internal.model;

import java.util.LinkedList;
import java.util.List;

import devutility.internal.annotation.Order;
import devutility.internal.util.RandomUtils;

/**
 * 
 * Member
 * 
 * @author: Aldwin Su
 * @version: 2019-04-14 13:00:11
 */
public class Member {
	@Order(2)
	private int id;

	@Order(1)
	private String value;

	@Order(3)
	private String name;

	@Order(4)
	private int age;

	private Long longValue;

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

	public Long getLongValue() {
		return longValue;
	}

	public void setLongValue(Long longValue) {
		this.longValue = longValue;
	}

	public static Member get() {
		return list(1).get(0);
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

	@Override
	public String toString() {
		return String.format("Member [id=%d, name=%s, value=%s, age=%d]", this.getId(), this.getName(), this.getValue(), this.getAge());
	}
}