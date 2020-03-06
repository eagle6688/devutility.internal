package devutility.internal.awt.position.string;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import devutility.internal.awt.FontUtils;
import devutility.internal.awt.position.Positioner;
import devutility.internal.models.Position;

/**
 * 
 * StringCenterPosition
 * 
 * @author: Aldwin Su
 * @version: 2020-03-06 16:49:22
 */
public class StringCenterPosition implements Positioner {
	@Override
	public Position calculate(BufferedImage image, Graphics2D graphics2d, Font font, String text) {
		Position position = new Position();
		position.setX(FontUtils.getCentricXOffset(image.getWidth(), graphics2d, font, text));
		position.setY(FontUtils.getCentricYOffset(image.getHeight(), graphics2d, font));
		return position;
	}
}