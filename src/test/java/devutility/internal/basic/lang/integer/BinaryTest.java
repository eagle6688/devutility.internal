package devutility.internal.basic.lang.integer;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class BinaryTest extends BaseTest {
	@Override
	public void run() {
		toBinaryString(1);
		toBinaryString(-1);
		toBinaryString(-1 & 1);
		toBinaryString(-1 << 1);
	}

	private void toBinaryString(int value) {
		System.out.println(String.format("Value: %d, Binary String: %s", value, Integer.toBinaryString(value)));
	}

	public static void main(String[] args) {
		TestExecutor.run(BinaryTest.class);
	}
}