package devutility.internal.util.function;

import java.util.function.Predicate;

public class PredicateBuilder<T> {
	// region variables

	private boolean hasPredicate = false;
	private Predicate<T> predicate;

	// endregion

	// region constructor

	public PredicateBuilder() {
		setPredicate(i -> true);
	}

	// endregion

	// region and

	public void and(Predicate<T> expression) {
		if (!hasPredicate) {
			hasPredicate = true;
			predicate = expression;
			return;
		}

		predicate = predicate.and(expression);
	}

	// endregion

	// region or

	public void or(Predicate<T> expression) {
		if (!hasPredicate) {
			hasPredicate = true;
			predicate = (expression);
			return;
		}

		predicate = (predicate.or(expression));
	}

	// endregion

	// region predicate

	public Predicate<T> getPredicate() {
		return predicate;
	}

	private void setPredicate(Predicate<T> predicate) {
		this.predicate = predicate;
	}

	// endregion

	// region is has predicate

	public boolean isHasPredicate() {
		return hasPredicate;
	}

	// endregion
}