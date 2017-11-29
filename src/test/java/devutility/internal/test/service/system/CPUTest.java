package devutility.internal.test.service.system;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class CPUTest extends BaseService {
	@Override
	public void run() {
		int coreCount = Runtime.getRuntime().availableProcessors();
		println(coreCount);
	}

	public static void main(String[] args) {
		ServiceExecutor.run(CPUTest.class);
	}
}