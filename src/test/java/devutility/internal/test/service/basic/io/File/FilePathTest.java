package devutility.internal.test.service.basic.io.File;

import java.io.File;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class FilePathTest extends BaseService {
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
		ServiceExecutor.run(FilePathTest.class);
	}
}