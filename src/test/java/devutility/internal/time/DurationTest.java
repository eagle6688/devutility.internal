package devutility.internal.time;

import java.time.Duration;
import java.time.Instant;

public class DurationTest {

	public static void main(String[] args) throws Exception {
		Instant start = Instant.now();
		Thread.sleep(1000);
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println(timeElapsed.getNano());
	}
}