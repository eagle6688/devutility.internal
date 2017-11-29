package devutility.internal.test.service.system;

import devutility.internal.system.SystemHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class SystemHelperTest extends BaseService {
	@Override
	public void run() {
		int count = SystemHelper.getProcessorsCount();
		println(count);

		int porperCount = SystemHelper.getProperProcessorsCount();
		println(porperCount);
	}

	public static void main(String[] args) {
		ServiceExecutor.run(SystemHelperTest.class);
	}
}