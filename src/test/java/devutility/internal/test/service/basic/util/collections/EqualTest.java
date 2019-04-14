package devutility.internal.test.service.basic.util.collections;

import java.util.List;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Member;

public class EqualTest extends BaseTest {
	private List<Member> list = Member.list(5);

	@Override
	public void run() {
		indexOf1();
		indexOf2();
		indexOfNull();
	}

	private void indexOf1() {
		Member member = new Member();
		member.setAge(list.get(3).getAge());
		member.setName(list.get(3).getName());
		println(list.indexOf(member));
	}

	private void indexOf2() {
		Member member = new Member();
		member.setAge(list.get(3).getAge());
		member.setName(list.get(3).getName());
		member.setValue("asd");
		println(list.indexOf(member));
	}

	private void indexOfNull() {
		println(list.indexOf(null));
	}

	public static void main(String[] args) {
		TestExecutor.run(EqualTest.class);
	}
}