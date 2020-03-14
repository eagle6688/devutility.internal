package devutility.internal.awt.position.text;

import java.awt.Font;
import java.awt.Graphics2D;

import devutility.internal.awt.FontUtils;
import devutility.internal.awt.image.ImageFactor;
import devutility.internal.awt.position.Position;
import devutility.internal.awt.position.Positioner;

/**
 * 
 * TextCenterPosition
 * 
 * @author: Aldwin Su
 * @version: 2020-03-06 16:49:22
 */
public class TextCenterPosition implements Positioner {
	@Override
	public Position calculate(ImageFactor imageFactor, Graphics2D graphics2d, Object... args) {
		Font font = (Font) args[0];
		String text = (String) args[1];

		Position position = new Position();
		position.setX(FontUtils.getCentricXOffset(imageFactor.getWidth(), graphics2d, font, text));
		position.setY(FontUtils.getCentricYOffset(imageFactor.getHeight(), graphics2d, font, text));
		return position;
	}
}