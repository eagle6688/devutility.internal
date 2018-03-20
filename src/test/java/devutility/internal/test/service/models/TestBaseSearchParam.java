package devutility.internal.test.service.models;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.StudentSearchParam;

public class TestBaseSearchParam extends BaseTest {
	@Override
	public void run() {
		String[] numbers = { "100001", "100002" };

		StudentSearchParam searchParam1 = new StudentSearchParam();
		searchParam1.setNumbers(numbers);
		println(searchParam1.isEmpty() ? "empty" : "not empty");

		StudentSearchParam searchParam2 = new StudentSearchParam();
		println(searchParam2.isEmpty() ? "empty" : "not empty");
	}

	public static void main(String[] args) {
		TestExecutor.run(TestBaseSearchParam.class);
	}
}