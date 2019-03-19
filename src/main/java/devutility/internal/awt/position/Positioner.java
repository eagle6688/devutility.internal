package devutility.internal.awt.position;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import devutility.internal.models.Position;

public interface Positioner {
	Position calculate(BufferedImage image, Graphics2D graphics2D, Object... params);
}