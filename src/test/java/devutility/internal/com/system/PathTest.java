package devutility.internal.com.system;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class PathTest extends BaseTest {
	@Override
	public void run() {
		println(String.format("System.getProperty(\"user.dir\"): %s", System.getProperty("user.dir")));
		println(String.format("Thread.currentThread().getContextClassLoader().getResource(\"\").getPath(): %s", Thread.currentThread().getContextClassLoader().getResource("").getPath()));
		println(String.format("ClassLoader.getSystemResource(\"\").getPath(): %s", ClassLoader.getSystemResource("").getPath()));
		println(String.format("PathTest.class.getClassLoader().getResource(\"\").getPath(): %s", PathTest.class.getClassLoader().getResource("").getPath()));
		println(String.format("PathTest.class.getResource(\"\").getPath(): %s", PathTest.class.getResource("").getPath()));
		println(String.format("PathTest.class.getResource(\"/\").getPath(): %s", PathTest.class.getResource("/").getPath()));
	}
	
	public static void main(String[] args) {
		TestExecutor.run(PathTest.class);
	}
}