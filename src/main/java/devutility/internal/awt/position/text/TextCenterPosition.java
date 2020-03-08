package devutility.internal.awt.position.text;

import java.awt.Font;
import java.awt.Graphics2D;

import devutility.internal.awt.FontUtils;
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
	public Position calculate(int width, int height, Graphics2D graphics2d, Font font, String text) {
		Position position = new Position();
		position.setX(FontUtils.getCentricXOffset(width, graphics2d, font, text));
		position.setY(FontUtils.getCentricYOffset(height, graphics2d, font, text));
		return position;
	}
}