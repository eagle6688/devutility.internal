package devutility.internal.awt.position;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import devutility.internal.models.Position;

/**
 * 
 * Positioners
 * 
 * @author: Aldwin Su
 * @version: 2020-03-06 15:39:07
 */
public interface Positioners {
	/**
	 * Calculate Positioner objects for provide parameters.
	 * @param image BufferedImage object.
	 * @param graphics2D Graphics2D object.s
	 * @param font Font object.
	 * @param text Text need write in image.
	 * @param xOffset Offset in horizontal direction.
	 * @param yOffset Offset in vertical direction.
	 * @return {@code List<Position>}
	 */
	public abstract List<Position> calculate(BufferedImage image, Graphics2D graphics2D, Font font, String text, float xOffset, float yOffset);
}