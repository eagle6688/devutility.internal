package devutility.internal.service.lang.ExceptionHelper;

import devutility.internal.lang.ExceptionHelper;
import devutility.internal.service.basic.lang.Objects.RequireNonNullService;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class ToStringService extends BaseService {
	@Override
	public void run() {
		try {
			ServiceExecutor.run(new RequireNonNullService(null));
		} catch (Exception e) {
			String content = ExceptionHelper.toString(e);
			println(content);
		}
	}
}