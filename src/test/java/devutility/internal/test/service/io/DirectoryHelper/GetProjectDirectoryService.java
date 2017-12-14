package devutility.internal.test.service.io.DirectoryHelper;

import devutility.internal.io.DirectoryHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetProjectDirectoryService extends BaseTest {
	@Override
	public void run() {
		println(DirectoryHelper.getProjectDirectory());
	}
	
	public static void main(String[] args) {
		TestExecutor.run(new GetProjectDirectoryService());
	}
}