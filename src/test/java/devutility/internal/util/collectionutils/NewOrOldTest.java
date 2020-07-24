package devutility.internal.util.collectionutils;

import java.util.List;

import devutility.internal.model.Member;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.CollectionUtils;

public class NewOrOldTest extends BaseTest {
	@Override
	public void run() {
		List<Member> members = Member.list(2);

		members.forEach(i -> {
			println(i.toString());
		});

		List<Member> list = CollectionUtils.list(members, i -> "Name1".equals(i.getName()));
		list.get(0).setName("Name1-Test");

		list.forEach(i -> {
			println(i.toString());
		});

		members.forEach(i -> {
			println(i.toString());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(NewOrOldTest.class);
	}
}