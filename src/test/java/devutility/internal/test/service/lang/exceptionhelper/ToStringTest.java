package devutility.internal.test.service.lang.exceptionhelper;

import java.util.Objects;

import devutility.internal.lang.ExceptionUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ToStringTest extends BaseTest {
	private Object value = null;

	@Override
	public void run() {
		try {
			Objects.requireNonNull(value, "value can not null in ToStringService!");
		} catch (Exception e) {
			e.printStackTrace();
			println(ExceptionUtils.toString(e));
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ToStringTest.class);
	}
}