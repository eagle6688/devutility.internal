package devutility.internal.awt;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class FontUtils {
	/**
	 * Return text width use Font object.
	 * @param graphics Graphics2D object.
	 * @param font Font object.
	 * @param value String value need display in Graphics2D object.
	 * @return int
	 */
	public static int getTextWidth(Graphics2D graphics, Font font, String value) {
		FontMetrics fontMetrics = graphics.getFontMetrics(font);
		return fontMetrics.stringWidth(value);
	}

	/**
	 * Return height of Font object.
	 * @param graphics Graphics2D object.
	 * @param font Font object.
	 * @return int
	 */
	public static int getHeight(Graphics2D graphics, Font font) {
		FontMetrics fontMetrics = graphics.getFontMetrics(font);
		return fontMetrics.getHeight();
	}

	/**
	 * Return X offset of centric position for string.
	 * @param imageWidth Image width.
	 * @param graphics Graphics2D object.
	 * @param font Font object.
	 * @param value String value.
	 * @return float
	 */
	public static float getCentricXOffset(int imageWidth, Graphics2D graphics, Font font, String value) {
		int width = FontUtils.getTextWidth(graphics, font, value);
		return (imageWidth - width) / 2;
	}

	/**
	 * Return Y offset of centric position for Font.
	 * @param imageHeight Image height.
	 * @param graphics Graphics2D object.
	 * @param font Font object.
	 * @return float
	 */
	public static float getCentricYOffset(int imageHeight, Graphics2D graphics, Font font) {
		FontMetrics fontMetrics = graphics.getFontMetrics(font);
		int height = fontMetrics.getHeight();
		return (imageHeight - height) / 2 + fontMetrics.getAscent();
	}
}