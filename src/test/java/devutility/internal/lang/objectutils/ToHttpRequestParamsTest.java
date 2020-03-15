package devutility.internal.lang.objectutils;

import java.lang.reflect.InvocationTargetException;

import devutility.internal.lang.ObjectUtils;
import devutility.internal.model.Member;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ToHttpRequestParamsTest extends BaseTest {
	@Override
	public void run() {
		Member member = new Member();
		member.setAge(10);
		member.setName("name1");
		member.setLongValue(100L);

		try {
			println(ObjectUtils.toHttpRequestParams(member));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ToHttpRequestParamsTest.class);
	}
}