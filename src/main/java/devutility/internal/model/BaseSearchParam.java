package devutility.internal.model;

import devutility.internal.util.function.PredicateBuilder;

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