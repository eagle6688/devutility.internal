package devutility.internal.executors.basic.lang;

import devutility.internal.service.basic.lang.StackTraceElement.GetStackTraceService;
import devutility.internal.test.ServiceExecutor;

public class StackTraceElementTest {
	public static void main(String[] args) {
		ServiceExecutor.run(new GetStackTraceService());
	}
}