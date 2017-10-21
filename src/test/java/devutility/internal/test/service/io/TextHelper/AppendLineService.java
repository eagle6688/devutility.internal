package devutility.internal.test.service.io.TextHelper;

import devutility.internal.io.TextHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

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
	
	public static void main(String[] args) throws Exception {
		ServiceExecutor.run(AppendLineService.class);
	}
}