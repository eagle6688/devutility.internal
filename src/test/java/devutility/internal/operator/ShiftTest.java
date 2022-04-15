package devutility.internal.operator;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ShiftTest extends BaseTest {
	@Override
	public void run() {
		int value = 3;
		println(String.format("Binary string: %s", Integer.toBinaryString(value)));

		int left1BitValue = value << 1;
		println(String.format("Shift left 1 bitwise: %s", left1BitValue));
		println(String.format("Binary string: %s", Integer.toBinaryString(left1BitValue)));

		int left2BitValue = value << 2;
		println(String.format("Shift left 2 bitwise: %s", left2BitValue));
		println(String.format("Binary string: %s", Integer.toBinaryString(left2BitValue)));

		int left3BitValue = value << 3;
		println(String.format("Shift left 3 bitwise: %s", left3BitValue));
		println(String.format("Binary string: %s", Integer.toBinaryString(left3BitValue)));

		leftShift(1L, 25);
		leftShift(1L, 37);
		leftShift(6435L, 0);
		leftShift(215504279049022L, 0);
		toLong("10000000000001100100100011");
		toLong("10000000000010000000000001100100100011");
		toLong("110001000010000000000010000000000001001100111110");
	}

	void leftShift(long value, int count) {
		long newValue = value << count;
		String binaryString = Long.toBinaryString(newValue);
		long _value = Long.valueOf(binaryString, 2);
		println(String.format("Binary string of %d is %s", _value, binaryString));
	}

	void toLong(String value) {
		long lValue = Long.valueOf(value, 2);
		println(String.format("Binary string of %s to long is %d", value, lValue));
	}

	public static void main(String[] args) {
		TestExecutor.run(ShiftTest.class);
	}
}