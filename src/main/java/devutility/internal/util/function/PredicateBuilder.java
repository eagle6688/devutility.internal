package devutility.internal.util.function;

import java.util.function.Predicate;

public class PredicateBuilder<T> {
	private boolean hasPredicate = false;
	private Predicate<T> predicate;

	public PredicateBuilder() {
		setPredicate(i -> true);
	}

	public void and(Predicate<T> expression) {
		if (!hasPredicate) {
			hasPredicate = true;
			predicate = expression;
			return;
		}

		predicate = predicate.and(expression);
	}

	public void or(Predicate<T> expression) {
		if (!hasPredicate) {
			hasPredicate = true;
			predicate = (expression);
			return;
		}

		predicate = (predicate.or(expression));
	}

	public Predicate<T> getPredicate() {
		return predicate;
	}

	private void setPredicate(Predicate<T> predicate) {
		this.predicate = predicate;
	}

	public boolean isHasPredicate() {
		return hasPredicate;
	}
}