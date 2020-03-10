package devutility.internal.test.operator;

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
	}

	public static void main(String[] args) {
		TestExecutor.run(ShiftTest.class);
	}
}