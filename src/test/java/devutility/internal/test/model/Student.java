package devutility.internal.test.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Person {
	private String number;
	private LocalDateTime entryTime;
	private String onlyGet;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}

	public String getOnlyGet() {
		return onlyGet;
	}

	public static List<Student> students(int count) {
		List<Student> list = new ArrayList<>(count);

		for (int i = 0; i < count; i++) {
			int number = i + 1;

			Student student = new Student();
			student.setAge(20);
			student.setBirthday(new Date());
			student.setLocal(true);
			student.setName(String.format("Name_%d", number));
			student.setNumber(String.valueOf(number));
			list.add(student);
		}

		return list;
	}
}