package devutility.internal.test.service.basic.util;

import java.util.UUID;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class UUIDTest extends BaseService {
	@Override
	public void run() {
		println(UUID.randomUUID().toString());
	}

	public static void main(String[] args) {
		ServiceExecutor.run(UUIDTest.class);
	}
}