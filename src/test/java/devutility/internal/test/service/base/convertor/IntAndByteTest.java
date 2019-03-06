package devutility.internal.test.service.base.convertor;

import devutility.internal.base.ConvertorUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class IntAndByteTest extends BaseTest {
	@Override
	public void run() {
		test(255);
		test(0);
		test(12);
		test(-12);
		test(-2);
	}

	private void test(int number) {
		System.out.format("Number: %d", number);

		byte b = ConvertorUtils.intToByte(number);
		System.out.format(", byte: %d", b);

		int newNumber = ConvertorUtils.byteToInt(b);
		System.out.format(", new number: %d\n", newNumber);

		byte[] bytes = ConvertorUtils.intToBytes(number);

		for (byte c : bytes) {
			System.out.format("%d, ", c);
		}

		System.out.println();
	}

	public static void main(String[] args) {
		TestExecutor.run(IntAndByteTest.class);
	}
}