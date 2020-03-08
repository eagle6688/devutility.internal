package devutility.internal.awt.position;

import java.awt.Font;
import java.awt.Graphics2D;

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
	 * @param width image object width.
	 * @param height image object height.
	 * @param graphics2D Graphics2D object.
	 * @param font Font object.
	 * @param text Text need write in image.
	 * @return Position
	 */
	Position calculate(int width, int height, Graphics2D graphics2D, Font font, String text);
}