package devutility.internal.test.service.lang.stringhelper;

import devutility.internal.lang.StringHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ConcatTest extends BaseTest {
	@Override
	public void run() {
		println(StringHelper.concat(""));
		println(StringHelper.concat("1", "2", "3", "4"));
		println("Concat completely!");
	}

	public static void main(String[] args) {
		TestExecutor.run(ConcatTest.class);
	}
}