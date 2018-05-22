package devutility.internal.util;

import java.util.Date;

public class DateUtils {
	/**
	 * Milliseconds to days
	 * @param milliseconds: Milliseconds
	 * @return long
	 */
	public static long millisecondsToDays(long milliseconds) {
		long dividend = 1000 * 60 * 60 * 24;
		long mod = milliseconds % dividend;
		long quotient = milliseconds / dividend;
		return mod == 0 ? quotient : quotient + 1;
	}

	/**
	 * Milliseconds to hours
	 * @param milliseconds: Milliseconds
	 * @return long
	 */
	public static long millisecondsToHours(long milliseconds) {
		long dividend = 1000 * 60 * 60;
		long mod = milliseconds % dividend;
		long quotient = milliseconds / dividend;
		return mod == 0 ? quotient : quotient + 1;
	}

	/**
	 * Subtract two dates and return days.
	 * @param d1: First date
	 * @param d2: Second date
	 * @return int
	 */
	public static int subtractToDays(Date d1, Date d2) {
		return (int) subtractToLongDays(d1, d2);
	}

	/**
	 * Subtract two dates and return days with long type.
	 * @param d1: First date
	 * @param d2: Second date
	 * @return long
	 */
	public static long subtractToLongDays(Date d1, Date d2) {
		return millisecondsToDays(d1.getTime() - d2.getTime());
	}

	/**
	 * Subtract two dates in hours
	 * @param d1: First date
	 * @param d2: Second date
	 * @return long
	 */
	public static long subtractToHours(Date d1, Date d2) {
		return millisecondsToHours(d1.getTime() - d2.getTime());
	}
}