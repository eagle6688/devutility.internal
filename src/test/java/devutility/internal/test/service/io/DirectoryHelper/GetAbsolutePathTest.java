package devutility.internal.test.service.io.DirectoryHelper;

import java.io.IOException;

import devutility.internal.io.DirectoryHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetAbsolutePathTest extends BaseTest {
	@Override
	public void run() {
		try {
			println(DirectoryHelper.toAbsolutePath("src/main/webapp/view/crossdomain/header.html"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetAbsolutePathTest.class);
	}
}