package devutility.internal.test.service.io.DirectoryHelper;

import devutility.internal.io.DirectoryHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class GetProjectDirectoryService extends BaseService {
	@Override
	public void run() {
		println(DirectoryHelper.getProjectDirectory());
	}
	
	public static void main(String[] args) {
		ServiceExecutor.run(new GetProjectDirectoryService());
	}
}