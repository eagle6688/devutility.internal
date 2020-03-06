package devutility.internal.awt;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * 
 * Graphics2DUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-03-18 20:05:20
 */
public class Graphics2DUtils {
	public static void drawString(Graphics2D graphics, Font font, Color color, AlphaComposite alphaComposite, String text, float positionX, float positionY) {
		graphics.setFont(font);
		graphics.setColor(color);
		graphics.setComposite(alphaComposite);
		graphics.drawString(text, positionX, positionY);
	}

	public static void drawString(Graphics2D graphics, Font font, Color color, float alpha, String text, float positionX, float positionY) {
		drawString(graphics, font, color, AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha), text, positionX, positionY);
	}

	public static void rotate(Graphics2D graphics, int width, int height, int slopeAngle) {
		if (slopeAngle > 0) {
			graphics.rotate(Math.toRadians(slopeAngle), width / 2, height / 2);
		}
	}
}