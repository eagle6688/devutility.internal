package devutility.internal.test.basic.util.collections;

import java.util.Collections;
import java.util.List;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SingletonListTest extends BaseTest {
	@Override
	public void run() {
		List<String> list = Collections.singletonList("asd");
		println(list.toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(SingletonListTest.class);
	}
}