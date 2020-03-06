package devutility.internal.awt.position.string;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import devutility.internal.awt.FontUtils;
import devutility.internal.awt.position.Positioner;
import devutility.internal.models.Position;

/**
 * 
 * StringBottomRightPosition
 * 
 * @author: Aldwin Su
 * @version: 2019-03-19 15:10:12
 */
public class StringBottomRightPosition implements Positioner {
	private float xRightOffset;
	private float yBottomOffset;

	public StringBottomRightPosition() {
	}

	public StringBottomRightPosition(float xRightOffset, float yBottomOffset) {
		this.xRightOffset = xRightOffset;
		this.yBottomOffset = yBottomOffset;
	}

	@Override
	public Position calculate(BufferedImage image, Graphics2D graphics2d, Font font, String text) {
		int textWidth = FontUtils.getTextWidth(graphics2d, font, text);

		Position position = new Position();
		position.setX(image.getWidth() - textWidth - xRightOffset);
		position.setY(image.getHeight() - yBottomOffset);
		return position;
	}
}