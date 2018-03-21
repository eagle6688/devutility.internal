package devutility.internal.text.format;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DateFormatHelper {
	/**
	 * container for SimpleDateFormat
	 */
	private static volatile Map<String, ThreadLocal<SimpleDateFormat>> container = new HashMap<>();

	/**
	 * Standard DateFormat
	 */
	public final static String STANDARDDATEFORMAT = "yyyy-MM-dd";

	/**
	 * Standard DateTime format
	 */
	public final static String STANDARDDATETIMEFORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * getStandardDateFormat 
	 * @return SimpleDateFormat
	 */
	public static SimpleDateFormat getStandardDateFormat() {
		return getSimpleDateFormat(STANDARDDATEFORMAT);
	}

	/**
	 * getSimpleDateFormat 
	 * @return SimpleDateFormat
	 */
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

	/**
	 * getSimpleDateFormat 
	 * @return SimpleDateFormat
	 */
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
}