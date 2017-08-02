package devutility.internal.basic.util;

public class ArrayTest {

	public static void main(String[] args) {
		// Pascal triangle
		int n = 5;
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
}