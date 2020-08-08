package devutility.internal.awt.rotation.text;

import devutility.internal.awt.image.ImageFactor;
import devutility.internal.awt.rotation.Rotation;
import devutility.internal.awt.rotation.RotationType;
import devutility.internal.awt.rotation.Rotator;

/**
 * 
 * TextSlopeCenterRotator
 * 
 * @author: Aldwin Su
 * @creation: 2020-03-10 15:26:49
 */
public class TextSlopeCenterRotator implements Rotator {
	@Override
	public Rotation calculate(ImageFactor imageFactor, Object... args) {
		Rotation rotation = new Rotation();
		rotation.setType(RotationType.PAINT);
		rotation.setRadians(imageFactor.getDiagonalRadians());
		rotation.setAnchorX(0);
		rotation.setAnchorY(0);
		return rotation;
	}
}