package devutility.internal.test.util.collectionutils;

import java.util.List;
import java.util.Map;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.model.Member;
import devutility.internal.util.CollectionUtils;

public class ParallelToMapTest extends BaseTest {
	@Override
	public void run() {
		List<Member> members = Member.list(100);
		Map<Integer, Member> map = CollectionUtils.parallelToMap(members, i -> i.getId() > 10, Member::getId, i -> i);

		map.keySet().forEach(i -> {
			println(i);
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(ParallelToMapTest.class);
	}
}