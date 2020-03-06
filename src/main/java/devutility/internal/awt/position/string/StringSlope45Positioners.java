package devutility.internal.awt.position.string;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import devutility.internal.awt.position.Positioners;
import devutility.internal.models.Position;

/**
 * 
 * Slope45Positioners
 * 
 * @author: Aldwin Su
 * @version: 2020-03-06 15:41:58
 */
public class StringSlope45Positioners implements Positioners {
	@Override
	public List<Position> calculate(BufferedImage image, Graphics2D graphics2d, Font font, String text, float xRightOffset, float yBottomOffset) {
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		double diagonalLength = Math.sqrt(Math.pow(imageWidth, 2) + Math.pow(imageHeight, 2));

		return null;
	}
}