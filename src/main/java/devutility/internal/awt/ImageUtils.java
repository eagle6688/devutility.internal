package devutility.internal.awt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * 
 * ImageUtils
 * 
 * @author: Aldwin Su
 */
public class ImageUtils {
	public static OutputStream waterMark(Image image, String text, int slopeAngle, Color color) {
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = bufferedImage.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		return null;
	}
}