package devutility.internal.service.basic.lang.StackTraceElement;

import java.util.Arrays;
import java.util.List;

import devutility.internal.service.basic.lang.Objects.RequireNonNullService;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class GetStackTraceService extends BaseService {
	@Override
	public void run() {
		try {
			ServiceExecutor.run(new RequireNonNullService(null));
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
}