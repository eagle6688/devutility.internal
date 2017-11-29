package devutility.internal.util;

import java.util.ArrayList;
import java.util.Comparator;
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

	public static <T, R> List<R> selectMany(List<T> list, Function<? super T, ? extends Stream<? extends R>> mapper) {
		List<R> result = new ArrayList<R>();

		list.stream().map(mapper).forEach(i -> {
			result.addAll(i.collect(Collectors.toList()));
		});

		return result;
	}

	// endregion

	// region min

	public static <T> T min(List<T> list, Comparator<? super T> comparator) {
		Optional<T> optional = list.stream().min(comparator);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	public static int minInt(List<Integer> list) {
		Integer value = min(list, Comparator.comparingInt(i -> i));

		if (value == null) {
			return 0;
		}

		return value;
	}

	// endregion

	// region max

	public static <T> T max(List<T> list, Comparator<? super T> comparator) {
		Optional<T> optional = list.stream().max(comparator);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	public static int maxInt(List<Integer> list) {
		Integer value = max(list, Comparator.comparingInt(i -> i));

		if (value == null) {
			return 0;
		}

		return value;
	}

	// endregion

	public static <T> List<T> paging(List<T> list, int pageIndex, int pageSize) {
		int skip = (pageIndex - 1) * pageSize;

		if (list == null || skip < 0 || skip >= list.size()) {
			return new ArrayList<T>();
		}

		return list.stream().skip(skip).limit(pageSize).collect(Collectors.toList());
	}
}