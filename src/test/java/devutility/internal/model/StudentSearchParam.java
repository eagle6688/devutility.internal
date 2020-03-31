package devutility.internal.model;

import java.util.Arrays;

import devutility.internal.annotation.Ignore;

public class StudentSearchParam extends BaseSearchParam<Student> {
	private String[] numbers;

	public String[] getNumbers() {
		return numbers;
	}

	public void setNumbers(String[] numbers) {
		this.numbers = numbers;
	}

	@Ignore
	public String testAnnotatedMethod() {
		return null;
	}

	@Override
	protected void buildPredicate() {
		if (numbers != null && numbers.length > 0) {
			predicateBuilder.and(i -> Arrays.asList(numbers).contains(i.getNumber()));
		}
	}
}