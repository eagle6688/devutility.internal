package devutility.internal.test.service.io.textfileutils;

import devutility.internal.io.TextFileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class AppendLineService extends BaseTest {
	@Override
	public void run() {
		try {
			TextFileUtils.appendLine("E:\\Downloads\\Test.txt", "newline");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		println("AppendLine completely!");
	}
	
	public static void main(String[] args) throws Exception {
		TestExecutor.run(AppendLineService.class);
	}
}