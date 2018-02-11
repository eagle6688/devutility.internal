package devutility.internal.data;

import java.util.List;

import devutility.internal.models.BaseSearchParam;
import devutility.internal.util.ListHelper;
import devutility.internal.util.function.PredicateBuilder;

/**
 * 
 * SearchHelper
 * @author: Aldwin Su 
 * @date:   2018-02-11 14:44:45  
 * @Copyright: 2018 All rights reserved.
 */
public class SearchHelper {
	public static <T> List<T> search(List<T> list, BaseSearchParam<T> searchParam) {
		PredicateBuilder<T> predicateBuilder = searchParam.getPredicateBuilder();

		if (!predicateBuilder.isHasPredicate()) {
			return list;
		}
		
		return ListHelper.parallelList(list, predicateBuilder.getPredicate());
	}
}