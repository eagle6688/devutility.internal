package devutility.internal.test.service.lang.ExceptionHelper;

import java.util.Objects;

import devutility.internal.lang.ExceptionHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ToStringService extends BaseTest {
	private Object value = null;

	@Override
	public void run() {
		try {
			Objects.requireNonNull(value, "value can not null in ToStringService!");
		} catch (Exception e) {
			e.printStackTrace();
			println(ExceptionHelper.toString(e));
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ToStringService.class);
	}
}