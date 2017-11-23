package devutility.internal.util;

public class DateHelper {
	public static int millisToDays(long millis) {
		return (int) (millis / (1000 * 60 * 60 * 24));
	}
}