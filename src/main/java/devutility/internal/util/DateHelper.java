package devutility.internal.util;

import java.util.Date;

public class DateHelper {
	/**
	 * Milliseconds to days
	 * @param millis: Milliseconds
	 * @return int
	 */
	public static int millisToDays(long millis) {
		return (int) (millis / (1000 * 60 * 60 * 24));
	}

	/**
	 * Subtract two dates in days
	 * @param d1: First date
	 * @param d2: Second date
	 * @return int
	 */
	public static int getDaySubtract(Date d1, Date d2) {
		return (int) ((d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000));
	}

	/**
	 * Subtract two dates in hours
	 * @param d1: First date
	 * @param d2: Second date
	 * @return int
	 */
	public static int getHoursSubtract(Date d1, Date d2) {
		return (int) ((d1.getTime() - d2.getTime()) / (60 * 60 * 1000));
	}
}