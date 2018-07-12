package devutility.internal.test.service.io.directoryutils;

import devutility.internal.io.DirectoryUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetProjectDirectoryTest extends BaseTest {
	@Override
	public void run() {
		println(DirectoryUtils.getProjectDirectory());
	}

	public static void main(String[] args) {
		TestExecutor.run(new GetProjectDirectoryTest());
	}
}