package devutility.internal.data;

import java.util.List;

import devutility.internal.models.BaseSearchParam;
import devutility.internal.util.CollectionUtils;
import devutility.internal.util.function.PredicateBuilder;

public class SearchUtils {
	public static <T> List<T> search(List<T> list, BaseSearchParam<T> searchParam) {
		PredicateBuilder<T> predicateBuilder = searchParam.getPredicateBuilder();

		if (!predicateBuilder.isHasPredicate()) {
			return list;
		}

		return CollectionUtils.parallelList(list, predicateBuilder.getPredicate());
	}

	/**
	 * Calculate pages count for given total count and page size.
	 * @param totalCount: Total records count.
	 * @param pageSize: Page size
	 * @return int
	 */
	public static int calculatePagesCount(int totalCount, int pageSize) {
		if (totalCount % pageSize == 0) {
			return totalCount / pageSize;
		}

		return totalCount / pageSize + 1;
	}
}