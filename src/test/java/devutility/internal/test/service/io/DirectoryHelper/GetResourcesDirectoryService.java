package devutility.internal.test.service.io.DirectoryHelper;

import devutility.internal.io.DirectoryHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetResourcesDirectoryService extends BaseTest {
	@Override
	public void run() {
		println(DirectoryHelper.getResourcesDirectory());
	}
	
	public static void main(String[] args) {
		TestExecutor.run(GetResourcesDirectoryService.class);
	}
}