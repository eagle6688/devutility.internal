package devutility.internal.service.io.TextHelper;

import devutility.internal.io.TextHelper;
import devutility.internal.test.BaseService;

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
}