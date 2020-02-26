package devutility.internal.test.util.collectionutils;

import java.util.Arrays;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.CollectionUtils;

public class CollectionUtils_SerializeTest extends BaseTest {
	@Override
	public void run() {
		test();
		testWithException();
	}

	void test() {
		String[] array = { "asd\",\"123", "qwe", null, "null", "nullnull" };
		println(CollectionUtils.serialize(Arrays.asList(array)));
	}

	void testWithException() {
		String[] array = { "asd\",\"123", "asd\\", "qwe", null, "null", "nullnull" };
		println(CollectionUtils.serialize(Arrays.asList(array)));
	}

	public static void main(String[] args) {
		TestExecutor.run(CollectionUtils_SerializeTest.class);
	}
}