package devutility.internal.text.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import devutility.internal.lang.StringHelper;

public class DateFormatHelper {
	private static volatile Object locker = new Object();
	private static Map<String, ThreadLocal<SimpleDateFormat>> dateFormatMap = new HashMap<>();

	// region format

	public final static String StandardDateFormat = "yyyy-MM-dd";

	public final static String StandardDateTimeFormat = "yyyy-MM-dd HH:mm:ss";

	// endregion

	// region get SimpleDateFormat

	public static SimpleDateFormat getSimpleDateFormat(final String pattern) {
		ThreadLocal<SimpleDateFormat> threadLocal = dateFormatMap.get(pattern);

		if (threadLocal != null) {
			return threadLocal.get();
		}

		synchronized (locker) {
			if (threadLocal == null) {
				threadLocal = new ThreadLocal<SimpleDateFormat>();
				threadLocal.set(new SimpleDateFormat(pattern));
				dateFormatMap.put(pattern, threadLocal);
			}
		}

		return threadLocal.get();
	}

	// endregion

	public static SimpleDateFormat getSimpleDateFormatWithStandardDateFormat() {
		return getSimpleDateFormat(StandardDateFormat);
	}

	public static Date toDate(String value, String pattern) throws ParseException {
		if (StringHelper.isNullOrEmpty(value)) {
			return null;
		}

		return getSimpleDateFormat(pattern).parse(value);
	}

	public static String toString(Date date, String pattern) {
		return getSimpleDateFormat(pattern).format(date);
	}
}