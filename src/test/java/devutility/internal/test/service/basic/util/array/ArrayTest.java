package devutility.internal.test.service.basic.util.array;

import java.util.Arrays;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ArrayTest extends BaseTest {
	@Override
	public void run() {
		twoDimensionalArray();
		pascalTriangle(10);
	}

	private void twoDimensionalArray() {
		String[][] arrays2 = new String[0][];

		for (String[] array2 : arrays2) {
			System.out.println(Arrays.toString(array2));
		}
	}

	private void pascalTriangle(int n) {
		int[][] triangle = new int[n][];

		for (int i = 0; i < n; i++) {
			triangle[i] = new int[i + 1];
			triangle[i][0] = 1;
			triangle[i][i] = 1;

			for (int j = 1; j < i; j++) {
				triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
			}
		}

		for (int[] row : triangle) {
			for (int element : row) {
				System.out.printf("%4d", element);
			}

			System.out.println();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ArrayTest.class);
	}
}