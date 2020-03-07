package devutility.internal.awt;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.LineMetrics;

public class FontUtils {
	/**
	 * Return text width use Font object.
	 * @param graphics Graphics2D object.
	 * @param font Font object.
	 * @param value String value need display in Graphics2D object.
	 * @return float
	 */
	public static float getWidth(Graphics2D graphics, Font font, String value) {
		FontMetrics fontMetrics = graphics.getFontMetrics(font);
		return fontMetrics.stringWidth(value);
	}

	/**
	 * Return height of Font object.
	 * @param graphics Graphics2D object.
	 * @param font Font object.
	 * @param text text content.
	 * @return float
	 */
	public static float getHeight(Graphics2D graphics, Font font, String text) {
		LineMetrics lineMetrics = font.getLineMetrics(text, graphics.getFontRenderContext());
		return lineMetrics.getHeight();
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
		float width = FontUtils.getWidth(graphics, font, value);
		return (imageWidth - width) / 2;
	}

	/**
	 * Return Y offset of centric position for Font.
	 * @param imageHeight Image height.
	 * @param graphics Graphics2D object.
	 * @param font Font object.
	 * @param text text content.
	 * @return float
	 */
	public static float getCentricYOffset(int imageHeight, Graphics2D graphics, Font font, String text) {
		LineMetrics lineMetrics = font.getLineMetrics(text, graphics.getFontRenderContext());
		float height = lineMetrics.getHeight();
		return (imageHeight - height) / 2 + lineMetrics.getAscent();
	}
}