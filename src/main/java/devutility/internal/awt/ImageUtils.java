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
	/**
	 * Add watermark in image.
	 * @param image Image object.
	 * @param text Watermark text.
	 * @param slopeAngle Watermark text slope angle.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param positionX Position X for watermark in image.
	 * @param positionY Position Y for watermark in image.
	 * @param extension Extension for new image.
	 * @return OutputStream
	 * @throws IOException
	 */
	public static OutputStream waterMark(Image image, String text, int slopeAngle, Font font, Color color, float positionX, float positionY, String extension) throws IOException {
		int width = image.getWidth(null);
		int height = image.getHeight(null);

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = bufferedImage.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

		Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		graphics.drawImage(scaledImage, 0, 0, null);

		if (slopeAngle > 0) {
			graphics.rotate(Math.toRadians(slopeAngle), width / 2, height / 2);
		}

		graphics.setColor(color);
		graphics.setFont(font);
		graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.15f));
		graphics.drawString(text, positionX, positionY);
		graphics.dispose();

		OutputStream outputStream = new ByteArrayOutputStream();

		if (!ImageIO.write(bufferedImage, extension, outputStream)) {
			return null;
		}

		return outputStream;
	}
}