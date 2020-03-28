package devutility.internal.math.triangle;

import devutility.internal.math.TriangleUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class EdgeTest extends BaseTest {
	@Override
	public void run() {
		System.out.println(TriangleUtils.edge(3, 4));
	}

	public static void main(String[] args) {
		TestExecutor.run(EdgeTest.class);
	}
}