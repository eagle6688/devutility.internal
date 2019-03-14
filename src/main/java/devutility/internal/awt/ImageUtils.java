package devutility.internal.awt;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

/**
 * 
 * ImageUtils
 * 
 * @author: Aldwin Su
 */
public class ImageUtils {
	public static OutputStream waterMark(Image image, String text, int slopeAngle, Color color, String formaName) throws IOException {
		int width = image.getWidth(null);
		int height = image.getHeight(null);

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = bufferedImage.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

		Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		graphics.drawImage(scaledImage, 0, 0, null);

		if (slopeAngle > 0) {
			graphics.rotate(Math.toRadians(slopeAngle), bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);
		}

		graphics.setColor(color);
		graphics.setFont(new Font(null, Font.BOLD, bufferedImage.getHeight() / 2));
		graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.15f));
		graphics.drawString(text, bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);
		graphics.dispose();

		OutputStream outputStream = new ByteArrayOutputStream();

		if (!ImageIO.write(bufferedImage, formaName, outputStream)) {
			return null;
		}

		return outputStream;
	}
}