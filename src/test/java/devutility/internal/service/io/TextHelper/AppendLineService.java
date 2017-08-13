package devutility.internal.service.io.TextHelper;

import devutility.internal.io.TextHelper;
import devutility.internal.test.BaseService;

public class AppendLineService extends BaseService {
	@Override
	public void run() {
		try {
			TextHelper.appendLine("E:\\Downloads\\Test.txt", "newline");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		println("AppendLine completely!");
	}
}