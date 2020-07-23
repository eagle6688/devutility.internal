package devutility.internal.math;

import java.math.BigDecimal;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class BigDecimalTest extends BaseTest {
	@Override
	public void run() {
		BigDecimal value1 = new BigDecimal(2);
		BigDecimal result = value1.multiply(new BigDecimal(2));
		System.out.println(value1);
		System.out.println(result);
		System.out.println(result.scale());
	}

	public static void main(String[] args) {
		TestExecutor.run(BigDecimalTest.class);
	}
}