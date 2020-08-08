package devutility.internal.awt.position.text;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.LineMetrics;

import devutility.internal.awt.FontUtils;
import devutility.internal.awt.image.ImageFactor;
import devutility.internal.awt.position.Position;
import devutility.internal.awt.position.Positioner;

/**
 * 
 * TextSlopeCenterPositioner
 * 
 * @author: Aldwin Su
 * @creation: 2020-03-08 15:06:45
 */
public class TextSlopeCenterPositioner implements Positioner {
	@Override
	public Position calculate(ImageFactor imageFactor, Graphics2D graphics2d, Object... args) {
		Font font = (Font) args[0];
		String text = (String) args[1];

		LineMetrics lineMetrics = font.getLineMetrics(text, graphics2d.getFontRenderContext());
		float textWidth = FontUtils.getWidth(graphics2d, font, text);
		float textHeight = lineMetrics.getHeight();

		double headerDiagonal = (imageFactor.getDiagonal() - textWidth) / 2;
		double xMidPoint = Math.sin(imageFactor.getDiagonalAnotherRadians()) * headerDiagonal;
		double yMidPoint = Math.sin(imageFactor.getDiagonalRadians()) * headerDiagonal;

		float longEdgeForBaselineMidPointTriangle = lineMetrics.getAscent() - textHeight / 2;
		double edgeXForBaselineMidPointTriangle = longEdgeForBaselineMidPointTriangle * Math.sin(imageFactor.getDiagonalRadians());
		double edgeYForBaselineMidPointTriangle = longEdgeForBaselineMidPointTriangle * Math.sin(imageFactor.getDiagonalAnotherRadians());

		double baselinePointX = xMidPoint - edgeXForBaselineMidPointTriangle;
		double baselinePointY = yMidPoint + edgeYForBaselineMidPointTriangle;

		Position position = new Position();
		position.setX((float) baselinePointX);
		position.setY((float) baselinePointY);
		return position;
	}
}