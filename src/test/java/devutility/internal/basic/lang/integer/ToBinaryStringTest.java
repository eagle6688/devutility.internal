package devutility.internal.basic.lang.integer;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ToBinaryStringTest extends BaseTest {
	@Override
	public void run() {
		toBinaryString(1);
		toBinaryString(8);
		toBinaryString(10);
		toBinaryString(-1);
		toBinaryString(-2);
		toBinaryString(-10);
	}

	void toBinaryString(int value) {
		String str = Integer.toBinaryString(value);
		System.out.println(String.format("Str: %s, Length: %d", str, str.length()));
	}

	public static void main(String[] args) {
		TestExecutor.run(ToBinaryStringTest.class);
	}
}