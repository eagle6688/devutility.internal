package devutility.internal.text.format;

import java.text.SimpleDateFormat;

public class DateFormatHelper {
	// region format

	public final static String StandardDateFormat = "yyyy-MM-dd";

	public final static String StandardDateTimeFormat = "yyyy-MM-dd HH:mm:ss";

	// endregion

	// region SimpleDateFormat

	public final static SimpleDateFormat StandardDate_SimpleDateFormat = new SimpleDateFormat(StandardDateFormat);

	public final static SimpleDateFormat StandardDateTime_SimpleDateFormat = new SimpleDateFormat(StandardDateTimeFormat);

	// endregion
}