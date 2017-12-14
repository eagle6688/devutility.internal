package devutility.internal.lang;

import java.util.ArrayList;
import java.util.List;

import devutility.internal.system.SystemHelper;

public class ExceptionHelper {
	// region to string

	public static String toString(Exception exception) {
		return toString(exception, SystemHelper.getNewLineChar());
	}

	public static String toString(Exception exception, String separator) {
		List<String> list = toList(exception);
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
			result.append(list.get(i));

			if (i < list.size() - 1) {
				result.append(separator);
			}
		}

		return result.toString();
	}

	// endregion

	// region to list

	public static List<String> toList(Exception exception) {
		List<String> list = new ArrayList<>();

		if (exception == null) {
			return list;
		}

		list.add(exception.getMessage());
		StackTraceElement[] stackTraceElements = exception.getStackTrace();

		if (stackTraceElements == null || stackTraceElements.length == 0) {
			return list;
		}

		for (StackTraceElement stackTraceElement : stackTraceElements) {
			list.add(stackTraceElement.toString());
		}

		return list;
	}

	// endregion
}