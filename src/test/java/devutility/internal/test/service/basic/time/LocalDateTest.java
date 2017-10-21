package devutility.internal.test.service.basic.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDateTest {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println(today.toString());

		LocalDate birthday = LocalDate.of(1988, Month.JANUARY, 8);
		System.out.println(birthday.toString());

		LocalDate nextBirthday = birthday.plusYears(1);
		System.out.println(nextBirthday.toString());

		long betweenDays = birthday.until(nextBirthday, ChronoUnit.DAYS);
		System.out.println(betweenDays);

		System.out.println(LocalDate.of(2017, 1, 31).plusMonths(1));
		System.out.println(LocalDate.of(2017, 3, 31).minusMonths(1));
	}
}