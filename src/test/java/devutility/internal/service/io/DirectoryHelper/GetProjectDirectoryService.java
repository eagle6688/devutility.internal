package devutility.internal.service.io.DirectoryHelper;

import devutility.internal.io.DirectoryHelper;
import devutility.internal.test.BaseService;

public class GetProjectDirectoryService extends BaseService {
	@Override
	public void run() {
		println(DirectoryHelper.getProjectDirectory());
	}
}