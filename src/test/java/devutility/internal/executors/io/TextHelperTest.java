package devutility.internal.executors.io;

import devutility.internal.service.io.TextHelper.*;
import devutility.internal.test.ServiceExecutor;

public class TextHelperTest {
	public static void main(String[] args) throws Exception {
		ServiceExecutor.run(AppendService.class);
		ServiceExecutor.run(AppendLineService.class);
	}
}