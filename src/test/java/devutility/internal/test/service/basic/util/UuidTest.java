package devutility.internal.test.service.basic.util;

import java.util.UUID;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class UuidTest extends BaseTest {
	@Override
	public void run() {
		println(UUID.randomUUID().toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(UuidTest.class);
	}
}