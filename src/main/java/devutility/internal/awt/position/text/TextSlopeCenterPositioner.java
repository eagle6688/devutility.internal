package devutility.internal.awt.position.text;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;

import devutility.internal.awt.FontUtils;
import devutility.internal.awt.position.Positioner;
import devutility.internal.models.Position;

/**
 * 
 * TextSlopeCenterPositioner
 * 
 * @author: Aldwin Su
 * @version: 2020-03-08 15:06:45
 */
public class TextSlopeCenterPositioner implements Positioner {
	@Override
	public Position calculate(BufferedImage image, Graphics2D graphics2d, Font font, String text) {
		Position position = new Position();
		int width = image.getWidth();
		int height = image.getHeight();
		double widthSquare = Math.pow(width, 2);
		double heightSquare = Math.pow(height, 2);
		double squareSum = widthSquare + heightSquare;
		double diagonal = Math.sqrt(squareSum);
		double diagonalSquare = Math.pow(diagonal, 2);

		double numeratorForAngleOfDiagonal = diagonalSquare + widthSquare - heightSquare;
		double denominatorForAngleOfDiagonal = 2 * diagonal * width;
		double resultForAngleOfDiagonal = numeratorForAngleOfDiagonal / denominatorForAngleOfDiagonal;
		double radians1ForAngleOfDiagonal = Math.acos(resultForAngleOfDiagonal);
		double radians2ForAngleOfDiagonal = Math.PI / 2 - radians1ForAngleOfDiagonal;

		LineMetrics lineMetrics = font.getLineMetrics(text, graphics2d.getFontRenderContext());
		float textWidth = FontUtils.getWidth(graphics2d, font, text);
		float textHeight = lineMetrics.getHeight();

		double headerDiagonal = (diagonal - textWidth) / 2;
		double xMidPoint = Math.sin(radians2ForAngleOfDiagonal) * headerDiagonal;
		double yMidPoint = Math.sin(radians1ForAngleOfDiagonal) * headerDiagonal;

		float longEdgeForBaselineMidPointTriangle = lineMetrics.getAscent() - textHeight / 2;
		double edgeXForBaselineMidPointTriangle = longEdgeForBaselineMidPointTriangle * Math.sin(radians1ForAngleOfDiagonal);
		double edgeYForBaselineMidPointTriangle = longEdgeForBaselineMidPointTriangle * Math.sin(radians2ForAngleOfDiagonal);

		double baselinePointX = xMidPoint - edgeXForBaselineMidPointTriangle;
		double baselinePointY = yMidPoint + edgeYForBaselineMidPointTriangle;

		position.setX((float) baselinePointX);
		position.setY((float) baselinePointY);
		return position;
	}
}