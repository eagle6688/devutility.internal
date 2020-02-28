package devutility.internal.test.util.collectionutils;

import java.util.List;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.CollectionUtils;

public class CollectionUtils_DeserializeTest extends BaseTest {
	@Override
	public void run() {
		String value = "asd\"\\,\"123,qwe,null,\\null,nullnull";
		List<String> list = CollectionUtils.deserialize(value);

		list.forEach(i -> {
			println(i);
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(CollectionUtils_DeserializeTest.class);
	}
}