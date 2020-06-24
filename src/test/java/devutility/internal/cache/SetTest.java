package devutility.internal.cache;

import java.util.ArrayList;
import java.util.List;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SetTest extends BaseTest {
	@Override
	public void run() {
		List<String> list = new ArrayList<String>();
		System.out.println(MemoryCache.set("test", list));

		SetTest model = new SetTest();
		System.out.println(MemoryCache.set("test1", model));
	}

	public static void main(String[] args) {
		TestExecutor.run(SetTest.class);
	}
}