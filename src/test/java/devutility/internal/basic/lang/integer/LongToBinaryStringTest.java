package devutility.internal.basic.lang.integer;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class LongToBinaryStringTest extends BaseTest {
	@Override
	public void run() {
		toBinaryString(4159L, false);
		toBinaryString(137472512063L, false);
		toBinaryString(211243709239359L, true);
	}

	void toBinaryString(long value, boolean position) {
		String str = Long.toBinaryString(value);
		System.out.println(String.format("Value: %d, Binary: %s", value, str));

		if (!position) {
			return;
		}

		for (int i = str.length(); i > 0; i--) {
			System.out.println(String.format("Right offset %d, value %c", str.length() - i, str.charAt(i - 1)));
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(LongToBinaryStringTest.class);
	}
}