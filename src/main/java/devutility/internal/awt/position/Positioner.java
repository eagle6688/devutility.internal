package devutility.internal.awt.position;

import java.awt.Graphics2D;

import devutility.internal.awt.image.ImageFactor;

/**
 * 
 * Positioner
 * 
 * @author: Aldwin Su
 * @creation: 2019-03-19 15:57:22
 */
public interface Positioner {
	/**
	 * Calculate Position object by provide parameters.
	 * @param imageFactor ImageFactor object.
	 * @param graphics Graphics2D object.
	 * @param args Other parameters used for calculate.
	 * @return Position
	 */
	Position calculate(ImageFactor imageFactor, Graphics2D graphics, Object... args);
}