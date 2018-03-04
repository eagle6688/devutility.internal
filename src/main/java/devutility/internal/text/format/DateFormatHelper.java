package devutility.internal.text.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import devutility.internal.lang.StringHelper;

public class DateFormatHelper {
	// region variables

	private static volatile Map<String, ThreadLocal<SimpleDateFormat>> container = new HashMap<>();

	public final static String STANDARDATEFORMAT = "yyyy-MM-dd";

	public final static String STANDARDATETIMEFORMAT = "yyyy-MM-dd HH:mm:ss";

	// endregion

	// region get SimpleDateFormat

	public static SimpleDateFormat getSimpleDateFormat(String pattern) {
		ThreadLocal<SimpleDateFormat> threadLocal = container.get(pattern);

		if (threadLocal != null) {
			if (threadLocal.get() != null) {
				return threadLocal.get();
			}

			container.put(pattern, null);
		}

		synchronized (DateFormatHelper.class) {
			if (container.get(pattern) == null) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				threadLocal = new ThreadLocal<SimpleDateFormat>();
				threadLocal.set(simpleDateFormat);
				container.put(pattern, threadLocal);
			}
		}

		return threadLocal.get();
	}

	public static SimpleDateFormat getSimpleDateFormat(String pattern, Locale locale) {
		String key = String.format("%s-%s", pattern, locale.toString());
		ThreadLocal<SimpleDateFormat> threadLocal = container.get(key);

		if (threadLocal != null) {
			if (threadLocal.get() != null) {
				return threadLocal.get();
			}

			container.put(key, null);
		}

		synchronized (DateFormatHelper.class) {
			if (container.get(key) == null) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
				threadLocal = new ThreadLocal<SimpleDateFormat>();
				threadLocal.set(simpleDateFormat);
				container.put(key, threadLocal);
			}
		}

		return threadLocal.get();
	}

	public static SimpleDateFormat getSimpleDateFormatWithStandardDateFormat() {
		return getSimpleDateFormat(STANDARDATEFORMAT);
	}

	// endregion

	// region to Date

	public static Date toDate(String value, String pattern) throws ParseException {
		if (StringHelper.isNullOrEmpty(value) || StringHelper.isNullOrEmpty(pattern)) {
			return null;
		}

		SimpleDateFormat simpleDateFormat = getSimpleDateFormat(pattern);
		return simpleDateFormat.parse(value);
	}

	public static Date toDate(String value, String pattern, Locale locale) throws ParseException {
		if (StringHelper.isNullOrEmpty(value) || StringHelper.isNullOrEmpty(pattern)) {
			return null;
		}

		SimpleDateFormat simpleDateFormat = getSimpleDateFormat(pattern, locale);
		return simpleDateFormat.parse(value);
	}

	// endregion

	// region to String

	public static String toString(Date date, String pattern) {
		return getSimpleDateFormat(pattern).format(date);
	}

	// endregion
}