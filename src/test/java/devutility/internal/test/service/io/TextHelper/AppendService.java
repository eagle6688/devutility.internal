package devutility.internal.test.service.io.TextHelper;

import devutility.internal.io.TextHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class AppendService extends BaseService {
	@Override
	public void run() {
		try {
			TextHelper.append("E:\\Downloads\\Test.txt", "asd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		println("Append completely!");
	}
	
	public static void main(String[] args) throws Exception {
		ServiceExecutor.run(AppendService.class);
	}
}