package devutility.internal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import devutility.internal.lang.StringHelper;
import devutility.internal.text.format.DateFormatHelper;

public class DateHelper {
	/**
	 * millisToDays 
	 * @return int
	 */
	public static int millisToDays(long millis) {
		return (int) (millis / (1000 * 60 * 60 * 24));
	}

	/**
	 * getDaySubtract 
	 * @return int
	 */
	public static int getDaySubtract(Date d1, Date d2) {
		return (int) ((d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000));
	}

	/**
	 * getHoursSubtract 
	 * @return int
	 */
	public static int getHoursSubtract(Date d1, Date d2) {
		return (int) ((d1.getTime() - d2.getTime()) / (60 * 60 * 1000));
	}

	/**
	 * toDate 
	 * @return Date
	 * @throws ParseException Date
	 */
	public static Date toDate(String value, String pattern) throws ParseException {
		if (StringHelper.isNullOrEmpty(value) || StringHelper.isNullOrEmpty(pattern)) {
			return null;
		}

		SimpleDateFormat simpleDateFormat = DateFormatHelper.getSimpleDateFormat(pattern);
		return simpleDateFormat.parse(value);
	}

	/**
	 * toDate 
	 * @return Date
	 * @throws ParseException Date
	 */
	public static Date toDate(String value, String pattern, Locale locale) throws ParseException {
		if (StringHelper.isNullOrEmpty(value) || StringHelper.isNullOrEmpty(pattern)) {
			return null;
		}

		SimpleDateFormat simpleDateFormat = DateFormatHelper.getSimpleDateFormat(pattern, locale);
		return simpleDateFormat.parse(value);
	}

	/**
	 * standardToDate 
	 * @return Date
	 * @throws ParseException Date
	 */
	public static Date standardToDate(String value) throws ParseException {
		return toDate(value, DateFormatHelper.STANDARDDATETIMEFORMAT);
	}

	/**
	 * format 
	 * @return String
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = DateFormatHelper.getSimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	/**
	 * formatToStandard 
	 * @return String
	 */
	public static String formatToStandard(Date date) {
		return format(date, DateFormatHelper.STANDARDDATETIMEFORMAT);
	}
}