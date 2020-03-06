package devutility.internal.awt.position;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import devutility.internal.models.Position;

/**
 * 
 * Positioner
 * 
 * @author: Aldwin Su
 * @version: 2019-03-19 15:57:22
 */
public interface Positioner {
	/**
	 * Calculate Positioner object for provide parameters.
	 * @param image BufferedImage object.
	 * @param graphics2D Graphics2D object.s
	 * @param font Font object.
	 * @param text Text need write in image.
	 * @return Position
	 */
	Position calculate(BufferedImage image, Graphics2D graphics2D, Font font, String text);
}