package devutility.internal.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import devutility.internal.data.BeanUtils;
import devutility.internal.lang.ClassHelper;
import devutility.internal.lang.models.EntityField;
import devutility.internal.system.SystemHelper;
import devutility.internal.util.concurrent.ConcurrentExecutor;

public class ListHelper {
	// region empty or not

	public static <T> boolean isEmpty(List<T> list) {
		return list == null || list.size() == 0;
	}

	public static <T> boolean isNotEmpty(List<T> list) {
		return list != null && list.size() > 0;
	}

	// endregion

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

	public static <T> Optional<T> parallelFindOptional(List<T> list, Predicate<T> predicate) {
		return list.stream().parallel().filter(predicate).findAny();
	}

	public static <T> T parallelFind(List<T> list, Predicate<T> predicate) {
		Optional<T> optional = parallelFindOptional(list, predicate);

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

	public static <T> Stream<T> parallelQuery(List<T> list, Predicate<T> predicate) {
		return list.stream().parallel().filter(predicate);
	}

	// endregion

	// region list

	public static <T> List<T> list(List<T> list, Predicate<T> predicate) {
		return query(list, predicate).collect(Collectors.toList());
	}

	public static <T> List<T> parallelList(List<T> list, Predicate<T> predicate) {
		return parallelQuery(list, predicate).collect(Collectors.toList());
	}

	// endregion

	// region count

	public static <T> int count(List<T> list, Predicate<T> predicate) {
		return (int) list.stream().filter(predicate).count();
	}

	// endregion

	// region map

	public static <T, R> List<R> map(List<T> list, Predicate<T> predicate, Function<? super T, ? extends R> mapper) {
		return query(list, predicate).map(mapper).collect(Collectors.toList());
	}

	public static <T, R> List<R> map(List<T> list, Function<? super T, ? extends R> mapper) {
		return list.stream().map(mapper).collect(Collectors.toList());
	}

	public static <T, R> List<R> mapAndDistinct(List<T> list, Predicate<T> predicate, Function<? super T, ? extends R> mapper) {
		return query(list, predicate).map(mapper).distinct().collect(Collectors.toList());
	}

	public static <T, R> List<R> mapAndDistinct(List<T> list, Function<? super T, ? extends R> mapper) {
		return list.stream().map(mapper).distinct().collect(Collectors.toList());
	}

	public static <T, R> List<R> mapMany(List<T> list, Function<? super T, ? extends Stream<? extends R>> mapper) {
		List<R> result = new ArrayList<R>();

		list.stream().map(mapper).forEach(i -> {
			result.addAll(i.collect(Collectors.toList()));
		});

		return result;
	}

	public static <T, R> Stream<R> parallelMapToStream(List<T> list, Function<? super T, ? extends R> mapper) {
		return list.stream().parallel().map(mapper);
	}

	public static <T, R> List<R> parallelMap(List<T> list, Function<? super T, ? extends R> mapper) {
		return parallelMapToStream(list, mapper).collect(Collectors.toList());
	}

	public static <T, R> List<R> parallelMapAndDistinct(List<T> list, Function<? super T, ? extends R> mapper) {
		return parallelMapToStream(list, mapper).distinct().collect(Collectors.toList());
	}

	public static <T, R> List<R> parallelMapAndDistinct(List<T> list, Predicate<T> predicate, Function<? super T, ? extends R> mapper) {
		return parallelQuery(list, predicate).map(mapper).distinct().collect(Collectors.toList());
	}

	/**
	 * Concurrent map
	 * @param list: List need map
	 * @param mapper: Mapper expression
	 * @return {@code List<R>}
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static <T, R> List<R> concurrentMap(List<T> list, Function<? super T, ? extends R> mapper) throws InterruptedException, ExecutionException {
		List<R> results = new ArrayList<>();
		int processorsCount = SystemHelper.getProcessorsCount();
		List<Callable<List<R>>> callables = new ArrayList<>(processorsCount);
		int pageSize = list.size() / processorsCount + list.size() % processorsCount;

		for (int i = 0; i < processorsCount; i++) {
			int start = i * pageSize;
			int targetEnd = start + pageSize;
			int end = targetEnd > list.size() ? list.size() : targetEnd;

			callables.add(() -> {
				return list.subList(start, end).stream().map(mapper).collect(Collectors.toList());
			});
		}

		List<List<R>> futureResults = ConcurrentExecutor.runAndGet(callables);

		for (List<R> futureResult : futureResults) {
			results.addAll(futureResult);
		}

		return results;
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

	// region paging

	public static <T> List<T> paging(List<T> list, int pageIndex, int pageSize) {
		if (list == null || pageIndex < 1) {
			return new ArrayList<T>();
		}

		int skip = (pageIndex - 1) * pageSize;

		if (skip < 0 || skip >= list.size()) {
			return new ArrayList<T>();
		}

		return list.stream().skip(skip).limit(pageSize).collect(Collectors.toList());
	}

	// endregion

	// region top

	public static <T> List<T> top(List<T> list, int count) {
		if (list == null || count < 1) {
			return new ArrayList<T>();
		}

		return list.stream().limit(count).collect(Collectors.toList());
	}

	// endregion

	// region group

	public static <T, K> Map<K, List<T>> groupToMap(List<T> list, Function<? super T, ? extends K> classifier) {
		return list.stream().collect(Collectors.groupingBy(classifier));
	}

	public static <T, K> List<K> group(List<T> list, Function<? super T, ? extends K> classifier) {
		Map<K, List<T>> map = groupToMap(list, classifier);
		return map.keySet().stream().collect(Collectors.toList());
	}

	public static <K, T> Map<K, List<T>> parallelGroupToMap(List<T> list, Function<? super T, ? extends K> classifier) {
		return list.stream().parallel().collect(Collectors.groupingBy(classifier));
	}

	// endregion

	/**
	 * List to arrays
	 * @param list: Bean list
	 * @param clazz: Class object of bean.
	 * @return String[][]
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static <T> String[][] toArrays(List<T> list, Class<T> clazz) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		List<EntityField> entityFields = ClassHelper.getEntityFields(clazz);

		if (list.size() == 0 || entityFields.size() == 0) {
			return null;
		}

		String[][] arrays = new String[list.size()][];

		for (int i = 0; i < list.size(); i++) {
			T entity = list.get(i);
			String[] array = BeanUtils.toArray(entity, entityFields);

			if (array != null) {
				arrays[i] = array;
			}
		}

		return arrays;
	}

	/**
	 * List to arrays
	 * @param list: Bean list.
	 * @param clazz: Class object of bean.
	 * @param excludeAnnotations: Annotations want to be excluded.
	 * @return String[][]
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static <T> String[][] toArrays(List<T> list, Class<T> clazz, List<Annotation> excludeAnnotations) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		List<EntityField> entityFields = ClassHelper.getEntityFields(clazz, excludeAnnotations);

		if (list.size() == 0 || entityFields.size() == 0) {
			return null;
		}

		String[][] arrays = new String[list.size()][];

		for (int i = 0; i < list.size(); i++) {
			T entity = list.get(i);
			String[] array = BeanUtils.toArray(entity, entityFields);

			if (array != null) {
				arrays[i] = array;
			}
		}

		return arrays;
	}

	/**
	 * Arrays to entities list
	 * @param arrays: Arrays
	 * @param clazz: Class object of bean.
	 * @return {@code List<T>}
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> List<T> toEntities(String[][] arrays, Class<T> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<T> list = new ArrayList<>(arrays.length);
		List<EntityField> entityFields = ClassHelper.getEntityFields(clazz);

		if (arrays == null || arrays.length == 0 || clazz == null || entityFields.size() == 0) {
			return list;
		}

		for (int i = 0; i < arrays.length; i++) {
			T entity = BeanUtils.toEntity(arrays[i], entityFields, clazz);

			if (entity != null) {
				list.add(entity);
			}
		}

		return list;
	}
}