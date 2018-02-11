package devutility.internal.models;

import devutility.internal.util.function.PredicateBuilder;

/**
 * 
 * SearchParam
 * @author: sufb1 
 * @date:   2018-02-11 13:44:56  
 * @Copyright: 2018 www.lenovo.com Inc. All rights reserved.
 */
public abstract class BaseSearchParam<T> {
	protected PredicateBuilder<T> predicateBuilder = new PredicateBuilder<>();

	public boolean isEmpty() {
		if (!predicateBuilder.isHasPredicate()) {
			buildPredicate();
		}

		return !predicateBuilder.isHasPredicate();
	}

	public PredicateBuilder<T> getPredicateBuilder() {
		if (!predicateBuilder.isHasPredicate()) {
			buildPredicate();
		}

		return predicateBuilder;
	}

	protected abstract void buildPredicate();
}