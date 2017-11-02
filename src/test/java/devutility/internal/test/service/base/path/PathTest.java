package devutility.internal.test.service.base.path;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class PathTest extends BaseService {
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
		ServiceExecutor.run(PathTest.class);
	}
}