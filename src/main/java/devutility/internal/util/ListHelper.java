package devutility.internal.util;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListHelper {
	public static <T> T find(List<T> list, Predicate<T> predicate) {
		Optional<T> optional = list.stream().filter(predicate).findAny();

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}
}