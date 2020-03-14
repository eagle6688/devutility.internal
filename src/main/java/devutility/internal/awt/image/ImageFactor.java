package devutility.internal.awt.image;

/**
 * 
 * ImageFactor
 * 
 * @author: Aldwin Su
 * @version: 2020-03-10 15:29:46
 */
public class ImageFactor {
	private int width;
	private int height;
	private double widthSquare;
	private double heightSquare;
	private double widthAndHeightSquareSum;
	private double diagonal;
	private double diagonalSquare;
	private double diagonalRadians;
	private double diagonalAnotherRadians;

	public ImageFactor() {
	}

	public ImageFactor(int width, int height) {
		this.width = width;
		this.height = height;
		this.widthSquare = Math.pow(width, 2);
		this.heightSquare = Math.pow(height, 2);
		this.widthAndHeightSquareSum = this.widthSquare + this.heightSquare;
		this.diagonal = Math.sqrt(this.widthAndHeightSquareSum);
		this.diagonalSquare = Math.pow(diagonal, 2);

		double fraction = height / diagonal;
		this.diagonalRadians = Math.asin(fraction);
		this.diagonalAnotherRadians = Math.PI / 2 - this.diagonalRadians;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWidthSquare() {
		return widthSquare;
	}

	public void setWidthSquare(double widthSquare) {
		this.widthSquare = widthSquare;
	}

	public double getHeightSquare() {
		return heightSquare;
	}

	public void setHeightSquare(double heightSquare) {
		this.heightSquare = heightSquare;
	}

	public double getWidthAndHeightSquareSum() {
		return widthAndHeightSquareSum;
	}

	public void setWidthAndHeightSquareSum(double widthAndHeightSquareSum) {
		this.widthAndHeightSquareSum = widthAndHeightSquareSum;
	}

	public double getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}

	public double getDiagonalSquare() {
		return diagonalSquare;
	}

	public void setDiagonalSquare(double diagonalSquare) {
		this.diagonalSquare = diagonalSquare;
	}

	public double getDiagonalRadians() {
		return diagonalRadians;
	}

	public void setDiagonalRadians(double diagonalRadians) {
		this.diagonalRadians = diagonalRadians;
	}

	public double getDiagonalAnotherRadians() {
		return diagonalAnotherRadians;
	}

	public void setDiagonalAnotherRadians(double diagonalAnotherRadians) {
		this.diagonalAnotherRadians = diagonalAnotherRadians;
	}
}