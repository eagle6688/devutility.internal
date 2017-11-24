package devutility.internal.text.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import devutility.internal.lang.StringHelper;

public class DateFormatHelper {
	private static volatile Map<String, ThreadLocal<SimpleDateFormat>> container = new HashMap<>();

	// region format

	public final static String StandardDateFormat = "yyyy-MM-dd";

	public final static String StandardDateTimeFormat = "yyyy-MM-dd HH:mm:ss";

	// endregion

	// region get SimpleDateFormat

	public static SimpleDateFormat getSimpleDateFormat(final String pattern) {
		ThreadLocal<SimpleDateFormat> threadLocal = container.get(pattern);

		if (threadLocal != null && threadLocal.get() != null) {
			return threadLocal.get();
		}

		synchronized (DateFormatHelper.class) {
			if (threadLocal == null || threadLocal.get() == null) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				ThreadLocal<SimpleDateFormat> newThreadLocal = new ThreadLocal<SimpleDateFormat>();
				newThreadLocal.set(simpleDateFormat);
				container.put(pattern, newThreadLocal);
				threadLocal = newThreadLocal;
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

		SimpleDateFormat simpleDateFormat = getSimpleDateFormat(pattern);
		return simpleDateFormat.parse(value);
	}

	public static String toString(Date date, String pattern) {
		return getSimpleDateFormat(pattern).format(date);
	}
}