package devutility.internal.test.service.basic.lang.StackTraceElement;

import java.util.Arrays;
import java.util.List;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.service.basic.lang.Objects.RequireNonNullService;

public class GetStackTraceService extends BaseTest {
	@Override
	public void run() {
		try {
			TestExecutor.run(new RequireNonNullService(null));
		} catch (Exception e) {
			StackTraceElement[] stackTraceElements = e.getStackTrace();
			List<StackTraceElement> stackTraceElementList = Arrays.asList(stackTraceElements);
			
			println("getMessage: %s", e.getMessage());
			
			println("toString:");
			
			stackTraceElementList.forEach(i -> {
				println(i.toString());
			});
			
			println("getFileName:");
			
			stackTraceElementList.forEach(i -> {
				println(i.getFileName());
			});
		}
	}
	
	public static void main(String[] args) {
		TestExecutor.run(GetStackTraceService.class);
	}
}