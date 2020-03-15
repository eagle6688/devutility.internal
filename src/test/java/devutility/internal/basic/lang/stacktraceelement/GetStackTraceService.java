package devutility.internal.basic.lang.stacktraceelement;

import java.util.Arrays;
import java.util.List;

import devutility.internal.basic.lang.objects.RequireNonNullService;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

/**
 * @Description: GetStackTraceService
 * @author: Aldwin
 */
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