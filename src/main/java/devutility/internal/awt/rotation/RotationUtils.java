package devutility.internal.awt.rotation;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 * 
 * RotationUtils
 * 
 * @author: Aldwin Su
 * @creation: 2020-03-14 11:25:47
 */
public class RotationUtils {
	/**
	 * Rotate provide Graphics2D object or Font object and return new Font object.
	 * @param graphics Graphics2D object.
	 * @param font Font object maybe need rotate to a new Font object.
	 * @param rotation Rotation object.
	 * @return Font
	 */
	public static Font rotate(Graphics2D graphics, Font font, Rotation rotation) {
		if (rotation == null || rotation.getRadians() == 0) {
			return font;
		}

		switch (rotation.getType()) {
		case GRAPHICS:
			graphics.rotate(rotation.getRadians(), rotation.getAnchorX(), rotation.getAnchorY());
			return font;

		case PAINT:
			AffineTransform affineTransform = new AffineTransform();
			affineTransform.rotate(rotation.getRadians(), rotation.getAnchorX(), rotation.getAnchorY());
			return font.deriveFont(affineTransform);

		default:
			return font;
		}
	}
}