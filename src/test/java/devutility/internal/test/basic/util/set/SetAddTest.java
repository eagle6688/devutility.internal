package devutility.internal.test.basic.util.set;

import java.util.LinkedHashSet;
import java.util.Set;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SetAddTest extends BaseTest {
	@Override
	public void run() {
		Set<String> set = new LinkedHashSet<>();
		println(String.valueOf(set.add("asd")));
		println(String.valueOf(set.add("asd")));
	}

	public static void main(String[] args) {
		TestExecutor.run(SetAddTest.class);
	}
}