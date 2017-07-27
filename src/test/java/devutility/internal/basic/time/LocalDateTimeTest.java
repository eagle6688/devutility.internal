package devutility.internal.basic.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;

public class LocalDateTimeTest {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.toString());

		System.out.println(now.isSupported(ChronoField.INSTANT_SECONDS) ? "support" : "not support");
		System.out.println(now.isSupported(ChronoField.MONTH_OF_YEAR) ? "support" : "not support");

		Instant instant = now.toInstant(ZoneOffset.of("+8"));
		System.out.println(instant.toString());
	}
}