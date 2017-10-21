package devutility.internal.test.service.system.Application;

import devutility.internal.io.DirectoryHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class GetResourcesDirectoryService extends BaseService {
	@Override
	public void run() {
		println(DirectoryHelper.getResourcesDirectory());
	}
	
	public static void main(String[] args) {
		ServiceExecutor.run(GetResourcesDirectoryService.class);
	}
}