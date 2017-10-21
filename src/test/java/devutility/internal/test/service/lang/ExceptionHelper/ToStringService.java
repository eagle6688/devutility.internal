package devutility.internal.test.service.lang.ExceptionHelper;

import devutility.internal.lang.ExceptionHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;
import devutility.internal.test.service.basic.lang.Objects.RequireNonNullService;

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
	
	public static void main(String[] args) {
		ServiceExecutor.run(ToStringService.class);
	}
}