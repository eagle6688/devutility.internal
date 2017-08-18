package devutility.internal.lang;

import java.util.ArrayList;
import java.util.List;

import devutility.internal.system.SystemHelper;

public class ExceptionHelper {
	public static String toString(Exception exception) {
		return toString(exception, SystemHelper.getNewLineChar());
	}

	public static String toString(Exception exception, String separator) {
		List<String> list = toStringList(exception);

		if (list == null || list.size() == 0) {
			return null;
		}

		int index = 0;
		StringBuilder stringBuilder = new StringBuilder();

		list.forEach(i -> {
			stringBuilder.append(i);

			if (index < list.size() - 1) {
				stringBuilder.append(separator);
			}
		});

		return stringBuilder.toString();
	}

	public static List<String> toStringList(Exception exception) {
		if (exception == null) {
			return null;
		}

		List<String> list = new ArrayList<>();
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
}