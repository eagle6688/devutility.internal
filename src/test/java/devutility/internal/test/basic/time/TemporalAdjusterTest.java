package devutility.internal.test.basic.time;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;

public class TemporalAdjusterTest {
	static TemporalAdjuster NEXT_WORKDAY = w -> {
		LocalDate result = (LocalDate) w;

		do {
			result = result.plusDays(1);
		} while (result.getDayOfWeek().getValue() >= 6);

		return result;
	};

	public static void main(String[] args) {
		LocalDate backToWork = LocalDate.now().with(NEXT_WORKDAY);
		System.out.println(backToWork.toString());
	}
}