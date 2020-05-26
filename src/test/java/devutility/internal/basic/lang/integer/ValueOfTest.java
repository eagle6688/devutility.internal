package devutility.internal.basic.lang.integer;

import java.math.BigInteger;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ValueOfTest extends BaseTest {
	@Override
	public void run() {
		valueOf("1", 2);
		valueOf("1000", 2);
		valueOf("1010", 2);
		valueOf("11111111111111111111111111111111", 2);
		valueOf("11111111111111111111111111111110", 2);
		valueOf("11111111111111111111111111110110", 2);
	}

	void valueOf(String value, int radix) {
		BigInteger bigInteger = new BigInteger(value, radix);
		System.out.println(String.format("Str: %s, Integer: %d", value, bigInteger.intValue()));
	}

	public static void main(String[] args) {
		TestExecutor.run(ValueOfTest.class);
	}
}