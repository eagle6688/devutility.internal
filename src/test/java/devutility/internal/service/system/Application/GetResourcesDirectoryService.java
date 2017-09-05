package devutility.internal.service.system.Application;

import devutility.internal.io.DirectoryHelper;
import devutility.internal.test.BaseService;

public class GetResourcesDirectoryService extends BaseService {
	@Override
	public void run() {
		println(DirectoryHelper.getResourcesDirectory());
	}
}