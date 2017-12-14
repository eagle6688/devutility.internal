package devutility.internal.test.service.lang.ExceptionHelper;

import devutility.internal.lang.ExceptionHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.service.basic.lang.Objects.RequireNonNullService;

public class ToStringService extends BaseTest {
	@Override
	public void run() {
		try {
			TestExecutor.run(new RequireNonNullService(null));
		} catch (Exception e) {
			String content = ExceptionHelper.toString(e);
			println(content);
		}
	}
	
	public static void main(String[] args) {
		TestExecutor.run(ToStringService.class);
	}
}