package devutility.internal.basic.util.stream;

import java.util.ArrayList;
import java.util.List;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.CollectionUtils;

public class ReferenceTest extends BaseTest {
	@Override
	public void run() {
		List<String> list = new ArrayList<>();
		list.add("asd");
		list.add("qwe");

		String first = CollectionUtils.find(list, i -> "asd".equals(i));
		first = "zxc";

		println(first);
		println(list.toString());

	}

	public static void main(String[] args) {
		TestExecutor.run(ReferenceTest.class);
	}
}