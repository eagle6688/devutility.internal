package devutility.internal.test.service.models;

import java.util.Arrays;

import devutility.internal.models.BaseSearchParam;
import devutility.internal.test.models.Student;

public class StudentSearchParam extends BaseSearchParam<Student> {
	private String[] numbers;

	public String[] getNumbers() {
		return numbers;
	}

	public void setNumbers(String[] numbers) {
		this.numbers = numbers;
	}

	@Override
	protected void buildPredicate() {
		if (numbers != null && numbers.length > 0) {
			predicateBuilder.and(i -> Arrays.asList(numbers).contains(i.getNumber()));
		}
	}
}