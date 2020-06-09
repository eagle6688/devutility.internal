package devutility.internal.lang;

import java.util.ArrayList;
import java.util.List;

import devutility.internal.com.SystemUtils;

/**
 * 
 * ExceptionUtils
 * 
 * @author: Aldwin Su
 * @version: 2017-08-18 23:32:34
 */
public class ExceptionUtils {
	public static String toString(Throwable throwable) {
		return toString(throwable, SystemUtils.lineSeparator());
	}

	public static String toString(Throwable throwable, String separator) {
		StringBuilder result = new StringBuilder();
		List<String> list = toList(throwable);

		for (int i = 0; i < list.size(); i++) {
			result.append(list.get(i));

			if (i < list.size() - 1) {
				result.append(separator);
			}
		}

		return result.toString();
	}

	public static List<String> toList(Throwable throwable) {
		List<String> list = new ArrayList<>();

		if (throwable == null) {
			return list;
		}

		list.add(String.format("%s: %s", throwable.getClass().getName(), throwable.getMessage()));
		StackTraceElement[] stackTraceElements = throwable.getStackTrace();

		if (stackTraceElements == null || stackTraceElements.length == 0) {
			return list;
		}

		for (StackTraceElement stackTraceElement : stackTraceElements) {
			list.add(String.format(" at %s", stackTraceElement.toString()));
		}

		return list;
	}
}