package devutility.internal.test.service.util.PropertiesHelper;

import java.util.Properties;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;
import devutility.internal.util.PropertiesHelper;

public class GetPropertiesService extends BaseService {
	@Override
	public void run() {
		Properties properties = PropertiesHelper.getProperties("system.properties");
		println(properties.getProperty("test"));
	}

	public static void main(String[] args) {
		ServiceExecutor.run(new GetPropertiesService());
	}
}