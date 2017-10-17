package devutility.internal.executors.io.DirectoryHelper;

import devutility.internal.service.io.DirectoryHelper.GetProjectDirectoryService;
import devutility.internal.test.ServiceExecutor;

public class GetProjectDirectoryTest {
	public static void main(String[] args) {
		ServiceExecutor.run(new GetProjectDirectoryService());
	}
}