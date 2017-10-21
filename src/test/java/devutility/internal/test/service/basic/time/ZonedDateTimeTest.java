package devutility.internal.test.service.basic.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeTest {

	public static void main(String[] args) {
		ZoneId zoneId = ZoneId.of("+8");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(2008, 8, 8, 20, 0, 0, 0, zoneId);
		System.out.println(zonedDateTime.toString());

		ZonedDateTime now = ZonedDateTime.now();
		System.out.println(now.toString());
	}
}