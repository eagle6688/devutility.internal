package devutility.internal.basic.util.set;

import java.util.LinkedHashSet;
import java.util.Set;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class LinkedHashSetTest extends BaseTest {
	@Override
	public void run() {
		Set<String> set = new LinkedHashSet<>();
		set.add(null);

		set.forEach(i -> {
			println(i);
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(LinkedHashSetTest.class);
	}
}