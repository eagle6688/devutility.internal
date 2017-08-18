package devutility.internal.executors.basic.lang;

import devutility.internal.service.basic.lang.Objects.RequireNonNullService;
import devutility.internal.test.ServiceExecutor;

public class ObjectsTest {
	public static void main(String[] args) {
		ServiceExecutor.run(new RequireNonNullService(null));
	}
}