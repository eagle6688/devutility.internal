package devutility.internal.test.data.model;

import java.time.LocalDateTime;

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
}