package devutility.internal.basic.util.map;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import devutility.internal.model.Member;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class MapTest extends BaseTest {
	@Override
	public void run() {
		Map<String, List<Member>> map = new LinkedHashMap<>();
		List<Member> members = Member.list(10);
		map.put("test", members);
		test(map);
		List<Member> list = map.get("test");

		list.forEach(i -> {
			println(i.toString());
		});
	}

	void test(Map<String, List<Member>> map) {
		List<Member> list = map.get("test");
		list.add(Member.get());
	}

	public static void main(String[] args) {
		TestExecutor.run(MapTest.class);
	}
}