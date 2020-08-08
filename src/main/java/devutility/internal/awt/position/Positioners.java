package devutility.internal.awt.position;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import devutility.internal.awt.image.ImageFactor;

/**
 * 
 * Positioners
 * 
 * @author: Aldwin Su
 * @creation: 2020-03-06 15:39:07
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
	List<Position> calculate(BufferedImage image, Graphics2D graphics2D, Font font, String text, float xOffset, float yOffset);

	/**
	 * Calculate Position objects by provide parameters.
	 * @param imageFactor ImageFactor object.
	 * @param graphics Graphics2D object.
	 * @param args Other parameters.
	 * @return {@code List<Position>}
	 */
	List<Position> calculate(ImageFactor imageFactor, Graphics2D graphics, Object... args);
}