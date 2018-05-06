package devutility.internal.data;

import java.util.List;

import devutility.internal.models.BaseSearchParam;
import devutility.internal.util.CollectionUtils;
import devutility.internal.util.function.PredicateBuilder;

public class SearchHelper {
	public static <T> List<T> search(List<T> list, BaseSearchParam<T> searchParam) {
		PredicateBuilder<T> predicateBuilder = searchParam.getPredicateBuilder();

		if (!predicateBuilder.isHasPredicate()) {
			return list;
		}

		return CollectionUtils.parallelList(list, predicateBuilder.getPredicate());
	}
}