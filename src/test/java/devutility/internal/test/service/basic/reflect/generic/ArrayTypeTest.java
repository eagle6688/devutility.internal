package devutility.internal.test.service.basic.reflect.generic;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class ArrayTypeTest extends BaseService {
	@Override
	public void run() {
		println(String[].class.getName());
		println(String[][].class.getName());
	}

	public static void main(String[] args) {
		ServiceExecutor.run(ArrayTypeTest.class);
	}
}