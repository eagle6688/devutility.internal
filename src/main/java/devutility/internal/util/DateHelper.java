package devutility.internal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import devutility.internal.lang.StringHelper;
import devutility.internal.text.format.DateFormatHelper;

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

	/**
	 * String to Date object
	 * @param value: Date string value
	 * @param pattern: Date string pattern
	 * @return Date
	 * @throws ParseException
	 */
	public static Date toDate(String value, String pattern) throws ParseException {
		if (StringHelper.isNullOrEmpty(value) || StringHelper.isNullOrEmpty(pattern)) {
			return null;
		}

		SimpleDateFormat simpleDateFormat = DateFormatHelper.getSimpleDateFormat(pattern);
		return simpleDateFormat.parse(value);
	}

	/**
	 * String to Date object
	 * @param value: Date string value
	 * @param pattern: Date string pattern
	 * @param locale: Date locale
	 * @return Date
	 * @throws ParseException
	 */
	public static Date toDate(String value, String pattern, Locale locale) throws ParseException {
		if (StringHelper.isNullOrEmpty(value) || StringHelper.isNullOrEmpty(pattern)) {
			return null;
		}

		SimpleDateFormat simpleDateFormat = DateFormatHelper.getSimpleDateFormat(pattern, locale);
		return simpleDateFormat.parse(value);
	}

	/**
	 * Date string with standard to Date object
	 * @param value
	 * @return Date
	 * @throws ParseException
	 */
	public static Date standardToDate(String value) throws ParseException {
		return toDate(value, DateFormatHelper.STANDARDDATETIMEFORMAT);
	}

	/**
	 * Format Date to string
	 * @param date: Date object
	 * @param pattern: Date pattern
	 * @return String
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = DateFormatHelper.getSimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	/**
	 * Format Date to standard string
	 * @param date: Date object
	 * @return String
	 */
	public static String formatToStandard(Date date) {
		return format(date, DateFormatHelper.STANDARDDATETIMEFORMAT);
	}
}