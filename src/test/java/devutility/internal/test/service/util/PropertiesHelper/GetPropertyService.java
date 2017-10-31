package devutility.internal.test.service.util.PropertiesHelper;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;
import devutility.internal.util.PropertiesHelper;

public class GetPropertyService extends BaseService {
	@Override
	public void run() {
		println(PropertiesHelper.getProperty("system.properties", "test"));
		println(PropertiesHelper.getProperty("system.properties", "Test"));
	}
	
	public static void main(String[] args) {
		ServiceExecutor.run(GetPropertyService.class);
	}
}