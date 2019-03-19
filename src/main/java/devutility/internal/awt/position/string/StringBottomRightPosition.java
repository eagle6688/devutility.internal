package devutility.internal.awt.position.string;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import devutility.internal.awt.FontUtils;
import devutility.internal.awt.position.Positioner;
import devutility.internal.models.Position;

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
	public Position calculate(BufferedImage image, Graphics2D graphics2d, Object... params) {
		if (params.length != 2) {
			throw new IllegalArgumentException("Illegal paramters!");
		}

		Font font = (Font) params[0];
		String text = (String) params[1];
		int stringWidth = FontUtils.getStringWidth(graphics2d, font, text);

		Position position = new Position();
		position.setX(image.getWidth() - stringWidth - xRightOffset);
		position.setY(image.getHeight() - yBottomOffset);
		return position;
	}
}