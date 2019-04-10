package devutility.internal.test.service.io.textfileutils;

import devutility.internal.io.TextFileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class AppendService extends BaseTest {
	@Override
	public void run() {
		try {
			TextFileUtils.append("E:\\Downloads\\Test.txt", "asd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		println("Append completely!");
	}
	
	public static void main(String[] args) throws Exception {
		TestExecutor.run(AppendService.class);
	}
}