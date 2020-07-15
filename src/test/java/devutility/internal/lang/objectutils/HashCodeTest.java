package devutility.internal.lang.objectutils;

import devutility.internal.lang.ObjectUtils;
import devutility.internal.model.Member;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class HashCodeTest extends BaseTest {
	@Override
	public void run() {
		println(ObjectUtils.hashCode(Member.get()));

		char ch = 'a';
		println(ObjectUtils.hashCode(ch));

		long lValue = 1000L;
		println(ObjectUtils.hashCode(lValue));
	}

	public static void main(String[] args) {
		TestExecutor.run(HashCodeTest.class);
	}
}