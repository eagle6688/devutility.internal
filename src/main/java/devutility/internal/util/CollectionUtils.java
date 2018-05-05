package devutility.internal.util;

import java.util.Collection;

public class CollectionUtils {
	public static <E> boolean nullOrEmpty(Collection<E> collection) {
		return collection == null || collection.size() == 0;
	}

	public static <E> boolean notEmpty(Collection<E> collection) {
		return collection != null && collection.size() > 0;
	}
}