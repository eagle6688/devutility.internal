package devutility.internal.awt;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import devutility.internal.awt.position.Position;
import devutility.internal.awt.rotation.Rotation;
import devutility.internal.awt.rotation.RotationUtils;

/**
 * 
 * Graphics2DUtils
 * 
 * @author: Aldwin Su
 * @creation: 2019-03-18 20:05:20
 */
public class Graphics2DUtils {
	/**
	 * Draw text in provide Graphics2D object.
	 * @param graphics Graphics2D object.
	 * @param font Font object.
	 * @param color rendering Color object.
	 * @param alphaComposite AlphaComposite object to be used for rendering.
	 * @param renderingHints RenderingHints object.
	 * @param x the x coordinate of the location where the <code>text</code> should be rendered.
	 * @param y the y coordinate of the location where the <code>text</code> should be rendered.
	 * @param text text need draw in Graphics2D.
	 */
	public static void drawString(Graphics2D graphics, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, float x, float y, String text) {
		if (renderingHints == null) {
			renderingHints = RenderingHintsUtils.highQuality();
		}

		graphics.setFont(font);
		graphics.setColor(color);
		graphics.setComposite(alphaComposite);
		graphics.setRenderingHints(renderingHints);
		graphics.drawString(text, x, y);
	}

	/**
	 * Draw text in provide Graphics2D object.
	 * @param graphics Graphics2D object.
	 * @param font Font object for String.
	 * @param color Color object for String.
	 * @param alphaComposite AlphaComposite object.
	 * @param renderingHints RenderingHints object.
	 * @param rotation Rotation object.
	 * @param position the coordinate of the location where the <code>text</code> should be rendered.
	 * @param text text need draw in Graphics2D.
	 */
	public static void drawString(Graphics2D graphics, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, Rotation rotation, Position position, String text) {
		font = RotationUtils.rotate(graphics, font, rotation);

		if (position == null) {
			position = new Position();
		}

		drawString(graphics, font, color, alphaComposite, renderingHints, position.getX(), position.getY(), text);
	}
}