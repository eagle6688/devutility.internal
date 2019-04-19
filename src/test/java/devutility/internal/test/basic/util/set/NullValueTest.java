package devutility.internal.test.basic.util.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class NullValueTest extends BaseTest {
	@Override
	public void run() {
		Set<String> set1 = new HashSet<>();
		set1.add(null);

		Set<String> set2 = new LinkedHashSet<>();
		set2.add(null);
	}

	public static void main(String[] args) {
		TestExecutor.run(NullValueTest.class);
	}
}