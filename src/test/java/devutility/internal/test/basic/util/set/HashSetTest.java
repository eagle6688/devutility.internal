package devutility.internal.test.basic.util.set;

import java.util.HashSet;
import java.util.Set;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class HashSetTest extends BaseTest {
	@Override
	public void run() {
		Set<String> set = new HashSet<>();
		set.add(null);

		set.forEach(i -> {
			println(i);
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(HashSetTest.class);
	}
}