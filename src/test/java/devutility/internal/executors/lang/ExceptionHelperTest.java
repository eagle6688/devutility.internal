package devutility.internal.executors.lang;

import devutility.internal.service.lang.ExceptionHelper.ToStringService;
import devutility.internal.test.ServiceExecutor;

public class ExceptionHelperTest {
	public static void main(String[] args) {
		ServiceExecutor.run(new ToStringService());
	}
}