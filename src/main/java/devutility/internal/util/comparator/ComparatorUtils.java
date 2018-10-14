package devutility.internal.util.comparator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Date;

public class ComparatorUtils {
	/**
	 * Create a Comparator object to compare the provided field (with Date type) use asc sort direction.
	 * @param getter: Getter method for field with Date type.
	 * @return {@code Comparator<E>}
	 */
	public static <E> Comparator<E> dateAscComparator(Method getter) {
		return (E o1, E o2) -> {
			Date value1 = null, value2 = null;

			try {
				value1 = (Date) getter.invoke(o1, new Object[0]);
				value2 = (Date) getter.invoke(o2, new Object[0]);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}

			if (value1 == null && value2 == null) {
				return 0;
			}

			if (value1 == null) {
				return -1;
			}

			if (value2 == null) {
				return 1;
			}

			return value1.compareTo(value2);
		};
	}

	/**
	 * Create a Comparator object to compare the provided field (with Date type) use desc sort direction.
	 * @param getter: Getter method for field with Date type.
	 * @return {@code Comparator<E>}
	 */
	public static <E> Comparator<E> dateDescComparator(Method getter) {
		return (E o1, E o2) -> {
			Date value1 = null, value2 = null;

			try {
				value1 = (Date) getter.invoke(o1, new Object[0]);
				value2 = (Date) getter.invoke(o2, new Object[0]);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}

			if (value1 == null && value2 == null) {
				return 0;
			}

			if (value1 == null) {
				return 1;
			}

			if (value2 == null) {
				return -1;
			}

			return value2.compareTo(value1);
		};
	}
}