package devutility.internal.awt.rotation;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 * 
 * RotationUtils
 * 
 * @author: Aldwin Su
 * @version: 2020-03-14 11:25:47
 */
public class RotationUtils {
	/**
	 * Rotate provide Graphics2D object or Font object. You can get rotated Font object by invoke getFont method.
	 * @param graphics Graphics2D object.
	 * @param font Font object.
	 * @param rotation Rotation object.
	 */
	public static void rotate(Graphics2D graphics, Font font, Rotation rotation) {
		if (rotation.getRadians() == 0) {
			return;
		}

		switch (rotation.getType()) {
		case GRAPHICS:
			graphics.rotate(rotation.getRadians(), rotation.getAnchorX(), rotation.getAnchorY());
			break;

		case PAINT:
			AffineTransform affineTransform = new AffineTransform();
			affineTransform.rotate(rotation.getRadians(), rotation.getAnchorX(), rotation.getAnchorY());
			Font rotatedFont = font.deriveFont(affineTransform);
			graphics.setFont(rotatedFont);
			break;

		default:
			break;
		}
	}
}