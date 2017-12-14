package devutility.internal.test.service.basic.io.File;

import java.io.File;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class FilePathTest extends BaseTest {
	@Override
	public void run() {
		println(String.format("File(\"\").getAbsolutePath(): %s", new File("").getAbsolutePath()));
		println(String.format("File(\"src\").getAbsolutePath(): %s", new File("src").getAbsolutePath()));
		println(String.format("File(\"\\\\src\").getAbsolutePath(): %s", new File("\\src").getAbsolutePath()));
		println(String.format("File(\"/src\").getAbsolutePath(): %s", new File("/src").getAbsolutePath()));
		println(String.format("File(\"./src\").getAbsolutePath(): %s", new File("./src").getAbsolutePath()));
		println(String.format("File(\"../src\").getAbsolutePath(): %s", new File("../src").getAbsolutePath()));
	}

	public static void main(String[] args) {
		TestExecutor.run(FilePathTest.class);
	}
}