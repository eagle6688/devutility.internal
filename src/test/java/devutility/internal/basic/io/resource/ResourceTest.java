package devutility.internal.basic.io.resource;

import java.net.URL;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ResourceTest extends BaseTest {
	@Override
	public void run() {
		URL url = this.getClass().getClassLoader().getResource("");
		println(url.toString());

		url = this.getClass().getClassLoader().getResource("system.properties");
		println(url.toString());

		url = this.getClass().getClassLoader().getResource("asd.properties");

		if (url == null) {
			println("No file");
		} else {
			println(url.toString());
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ResourceTest.class);
	}
}