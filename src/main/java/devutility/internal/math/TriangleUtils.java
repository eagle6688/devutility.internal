package devutility.internal.math;

/**
 * 
 * TriangleUtils
 * 
 * @author: Aldwin Su
 * @version: 2020-03-08 16:02:00
 */
public class TriangleUtils {
	/**
	 * Calculate length of the third edge.
	 * @param edge1 length of the first edge.
	 * @param edge2 length of the second egde.
	 * @return double
	 */
	public static double edge(double edge1, double edge2) {
		double edge1Square = Math.pow(edge1, 2);
		double edge2Square = Math.pow(edge2, 2);
		double sum = edge1Square + edge2Square;
		return Math.sqrt(sum);
	}

	public static double radians(double edge1, double edge2) {
		double edge1Square = Math.pow(edge1, 2);
		double edge2Square = Math.pow(edge2, 2);
		double squareSum = edge1Square + edge2Square;
		double diagonal = Math.sqrt(squareSum);
		double diagonalSquare = Math.pow(diagonal, 2);
		double numeratorForAngleOfDiagonal = diagonalSquare + edge1Square - edge2Square;
		double denominatorForAngleOfDiagonal = 2 * diagonal * edge1;
		double resultForAngleOfDiagonal = numeratorForAngleOfDiagonal / denominatorForAngleOfDiagonal;
		return Math.acos(resultForAngleOfDiagonal);
	}
}