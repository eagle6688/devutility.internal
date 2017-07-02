package devutility.internal.time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class InstantTest {

	public static void main(String[] args) {
		// UTC time
		Instant now = Instant.now();
		System.out.println(now.toString());

		// Add hours, method 1.
		Instant beijingNow = now.plus(Duration.ofHours(8));
		System.out.println(beijingNow.toString());

		// Add hours, method 2.
		Instant beijingTime = now.plus(8, ChronoUnit.HOURS);
		System.out.println(beijingTime.toString());

		// Compare two instants.
		System.out.println(now.compareTo(beijingNow));
		System.out.println(beijingTime.compareTo(beijingNow));
		System.out.println(beijingTime.compareTo(now));

		// Get second number.
		System.out.println(beijingNow.getEpochSecond());

		// Get nano number.
		System.out.println(beijingNow.getNano());

		// Restore tiem by second and nano.
		Instant time = Instant.ofEpochSecond(beijingNow.getEpochSecond(), beijingNow.getNano());
		System.out.println(time.toString());

		//TimeStamp
		System.out.println(now.getEpochSecond());
	}
}