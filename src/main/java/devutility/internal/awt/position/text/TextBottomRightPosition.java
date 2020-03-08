package devutility.internal.awt.position.text;

import java.awt.Font;
import java.awt.Graphics2D;

import devutility.internal.awt.FontUtils;
import devutility.internal.awt.position.Position;
import devutility.internal.awt.position.Positioner;

/**
 * 
 * TextBottomRightPosition
 * 
 * @author: Aldwin Su
 * @version: 2019-03-19 15:10:12
 */
public class TextBottomRightPosition implements Positioner {
	private float xRightOffset;
	private float yBottomOffset;

	public TextBottomRightPosition() {
	}

	public TextBottomRightPosition(float xRightOffset, float yBottomOffset) {
		this.xRightOffset = xRightOffset;
		this.yBottomOffset = yBottomOffset;
	}

	@Override
	public Position calculate(int width, int height, Graphics2D graphics2d, Font font, String text) {
		float textWidth = FontUtils.getWidth(graphics2d, font, text);
		float textDescent = FontUtils.getDescent(graphics2d, font, text);

		Position position = new Position();
		position.setX(width - textWidth - xRightOffset);
		position.setY(height - textDescent - yBottomOffset);
		return position;
	}
}