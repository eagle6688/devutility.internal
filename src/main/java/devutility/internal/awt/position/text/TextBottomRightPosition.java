package devutility.internal.awt.position.text;

import java.awt.Font;
import java.awt.Graphics2D;

import devutility.internal.awt.FontUtils;
import devutility.internal.awt.image.ImageFactor;
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
	public Position calculate(ImageFactor imageFactor, Graphics2D graphics, Object... args) {
		Font font = (Font) args[0];
		String text = (String) args[1];
		float textWidth = FontUtils.getWidth(graphics, font, text);
		float textDescent = FontUtils.getDescent(graphics, font, text);

		Position position = new Position();
		position.setX(imageFactor.getWidth() - textWidth - xRightOffset);
		position.setY(imageFactor.getHeight() - textDescent - yBottomOffset);
		return position;
	}
}