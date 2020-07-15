package devutility.internal.cache;

import devutility.internal.model.Member;
import devutility.internal.model.Person;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SetTest extends BaseTest {
	@Override
	public void run() {
		Member member = Member.get();
		Person person = Person.get();

		MemoryCache.set("member", member);
		MemoryCache.set("person", person);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		println(MemoryCache.get("member").toString());
		println(MemoryCache.get("person").toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(SetTest.class);
	}
}