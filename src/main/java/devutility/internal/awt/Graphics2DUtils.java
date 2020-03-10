package devutility.internal.awt;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import devutility.internal.awt.position.Position;
import devutility.internal.awt.rotation.Rotation;

/**
 * 
 * Graphics2DUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-03-18 20:05:20
 */
public class Graphics2DUtils {
	/**
	 * Draw text in provide Graphics2D object.
	 * @param graphics Graphics2D object.
	 * @param font Font object.
	 * @param color rendering Color object.
	 * @param alphaComposite AlphaComposite object to be used for rendering.
	 * @param text text need draw in Graphics2D.
	 * @param x the x coordinate of the location where the <code>text</code> should be rendered.
	 * @param y the y coordinate of the location where the <code>text</code> should be rendered.
	 */
	public static void drawString(Graphics2D graphics, Font font, Color color, AlphaComposite alphaComposite, String text, float x, float y) {
		graphics.setFont(font);
		graphics.setColor(color);
		graphics.setComposite(alphaComposite);
		graphics.drawString(text, x, y);
	}

	/**
	 * Draw text in provide Graphics2D object.
	 * @param graphics Graphics2D object.
	 * @param font Font object.
	 * @param color rendering Color object.
	 * @param alpha the constant alpha to be multiplied with the alpha ofthe source. alpha must be a floating point number
	 *            in theinclusive range [0.0, 1.0].
	 * @param text text need draw in Graphics2D.
	 * @param position Position object with x and y coordinate where the <code>text</code> should be rendered.
	 */
	public static void drawString(Graphics2D graphics, Font font, Color color, float alpha, String text, Position position) {
		drawString(graphics, font, color, AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha), text, position.getX(), position.getY());
	}

	public static void rotate(Graphics2D graphics, int width, int height, int slopeAngle) {
		if (slopeAngle > 0) {
			graphics.rotate(Math.toRadians(slopeAngle), width / 2, height / 2);
		}
	}

	/**
	 * Rotate provide Graphics2D object.
	 * @param graphics Graphics2D object.
	 * @param rotation Rotation object.
	 */
	public static void rotate(Graphics2D graphics, Rotation rotation) {
		if (rotation.getRadians() == 0) {
			return;
		}

		graphics.rotate(rotation.getRadians(), rotation.getAnchorX(), rotation.getAnchorY());
	}
}