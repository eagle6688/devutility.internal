package devutility.internal.test.io.directoryutils;

import devutility.internal.io.DirectoryUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetResourcesDirectoryTest extends BaseTest {
	@Override
	public void run() {
		println(DirectoryUtils.getResourcesDirectory());
	}

	public static void main(String[] args) {
		TestExecutor.run(GetResourcesDirectoryTest.class);
	}
}