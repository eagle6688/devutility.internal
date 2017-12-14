package devutility.internal.test.service.basic.util;

import java.util.UUID;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class UUIDTest extends BaseTest {
	@Override
	public void run() {
		println(UUID.randomUUID().toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(UUIDTest.class);
	}
}