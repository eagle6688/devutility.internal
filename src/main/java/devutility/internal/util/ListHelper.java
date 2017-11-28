package devutility.internal.util;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListHelper {
	// region exist

	public static <T> boolean exist(List<T> list, Predicate<T> predicate) {
		return count(list, predicate) > 0;
	}

	// endregion

	// region find

	public static <T> T find(List<T> list, Predicate<T> predicate) {
		Optional<T> optional = list.stream().filter(predicate).findAny();

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	// endregion

	// region query

	public static <T> Stream<T> query(List<T> list, Predicate<T> predicate) {
		return list.stream().filter(predicate);
	}

	// endregion

	// region list

	public static <T> List<T> list(List<T> list, Predicate<T> predicate) {
		return query(list, predicate).collect(Collectors.toList());
	}

	// endregion

	// region count

	public static <T> int count(List<T> list, Predicate<T> predicate) {
		return (int) list.stream().filter(predicate).count();
	}

	// endregion

	// region select

	public static <T, R> List<R> select(List<T> list, Predicate<T> predicate, Function<? super T, ? extends R> mapper) {
		return query(list, predicate).map(mapper).collect(Collectors.toList());
	}

	public static <T, R> List<R> select(List<T> list, Function<? super T, ? extends R> mapper) {
		return list.stream().map(mapper).collect(Collectors.toList());
	}

	// endregion
}