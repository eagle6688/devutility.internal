package devutility.internal.util;

import java.text.ParseException;
import java.util.Date;

import devutility.internal.text.format.DateFormatHelper;

public class DateHelper {
	public static int millisToDays(long millis) {
		return (int) (millis / (1000 * 60 * 60 * 24));
	}

	public static int getDaySubtract(Date d1, Date d2) {
		return (int) ((d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000));
	}

	public static int getHoursSubtract(Date d1, Date d2) {
		return (int) ((d1.getTime() - d2.getTime()) / (60 * 60 * 1000));
	}

	public static Date toDate(String value, String pattern) {
		try {
			return DateFormatHelper.toDate(value, pattern);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}