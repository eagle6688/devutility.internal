package devutility.internal.test.basic.lang.objects;

import java.util.Objects;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

/**
 * @Description: RequireNonNullService
 * @author: Aldwin
 */
public class RequireNonNullService extends BaseTest {
	String value;

	public RequireNonNullService(String value) {
		this.value = value;
	}

	@Override
	public void run() {
		String str = Objects.requireNonNull(value, "value can not null in RequireNonNullService!");
		println(str);
	}

	public static void main(String[] args) {
		TestExecutor.run(new RequireNonNullService(null));
	}
}