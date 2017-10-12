package devutility.internal.executors.io.RandomAccessFileHelper;

import devutility.internal.service.io.RandomAccessFileHelper.AsyncAppendService;
import devutility.internal.test.ServiceExecutor;

public class AsyncAppendTest {
	public static void main(String[] args) {
		ServiceExecutor.run(new AsyncAppendService());
	}
}