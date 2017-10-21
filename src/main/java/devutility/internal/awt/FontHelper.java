package devutility.internal.awt;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class FontHelper {
	public static int getFontWidth(Graphics2D graphics2d, Font font, String value) {
		FontMetrics fontMetrics = graphics2d.getFontMetrics(font);
		return fontMetrics.stringWidth(value);
	}

	public static int getFontHeight(Graphics2D graphics2d, Font font) {
		FontMetrics fontMetrics = graphics2d.getFontMetrics(font);
		return fontMetrics.getHeight();
	}

	public static float getXOffset(int backgroundWidth, Graphics2D graphics2d, Font font, String value) {
		int width = FontHelper.getFontWidth(graphics2d, font, value);
		return (backgroundWidth - width) / 2;
	}
	
	public static float getYOffset(int backgroundHeight, Graphics2D graphics2d, Font font) {
		FontMetrics fontMetrics = graphics2d.getFontMetrics(font);
		int height = fontMetrics.getHeight();
		return (backgroundHeight - height) / 2 + fontMetrics.getAscent();
	}
}