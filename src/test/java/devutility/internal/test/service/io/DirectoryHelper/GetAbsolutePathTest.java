package devutility.internal.test.service.io.DirectoryHelper;

import java.io.IOException;

import devutility.internal.io.DirectoryHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class GetAbsolutePathTest extends BaseService {
	@Override
	public void run() {
		try {
			println(DirectoryHelper.toAbsolutePath("src/main/webapp/view/crossdomain/header.html"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServiceExecutor.run(GetAbsolutePathTest.class);
	}
}