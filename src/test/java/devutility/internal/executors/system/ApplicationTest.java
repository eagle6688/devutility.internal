package devutility.internal.executors.system;

import devutility.internal.service.system.Application.GetPropertyService;
import devutility.internal.service.system.Application.GetResourcesDirectoryService;
import devutility.internal.test.ServiceExecutor;

public class ApplicationTest {
	public static void main(String[] args) {
		ServiceExecutor.run(new GetPropertyService());
		ServiceExecutor.run(new GetResourcesDirectoryService());
	}
}