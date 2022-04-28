package devutility.internal.basic.lang.integer;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class LongToBinaryStringTest extends BaseTest {
	@Override
	public void run() {
		toBinaryString(4159L, false);
		toBinaryString(137472512063L, false);
		toBinaryString(26388303753279L, true);
	}

	void toBinaryString(long value, boolean position) {
		String str = Long.toBinaryString(value);
		System.out.println(String.format("Value: %d, Binary: %s", value, str));

		if (!position) {
			return;
		}
		
		for (int i = 0; i < str.length(); i++) {
			System.out.println(String.format("Right index %d, value %c", i + 1, str.charAt(i)));
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(LongToBinaryStringTest.class);
	}
}