package devutility.internal.awt.rotation;

import devutility.internal.awt.image.ImageFactor;

/**
 * 
 * Rotator
 * 
 * @author: Aldwin Su
 * @version: 2020-03-09 00:07:20
 */
public interface Rotator {
	/**
	 * Calculate Rotation object.
	 * @param imageFactor ImageFactor object.
	 * @param args Other parameters.
	 * @return Rotation
	 */
	Rotation calculate(ImageFactor imageFactor, Object... args);
}