package devutility.internal.awt.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import devutility.internal.awt.Graphics2DUtils;
import devutility.internal.awt.position.Position;
import devutility.internal.awt.position.Positioner;
import devutility.internal.awt.rotation.Rotation;
import devutility.internal.awt.rotation.Rotator;

/**
 * 
 * ImageUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-03-19 15:57:33
 */
public class ImageUtils {
	/**
	 * Write text in image, return BufferedImage object with string.
	 * @param image Original BufferedImage object.
	 * @param font Font object for String.
	 * @param color Color object for String.
	 * @param alphaComposite AlphaComposite object.
	 * @param renderingHints RenderingHints object.
	 * @param rotation Rotation object.
	 * @param position the coordinate of the location where the <code>text</code> should be rendered.
	 * @param text text need draw in Graphics2D.
	 * @return BufferedImage
	 */
	public static BufferedImage drawText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, Rotation rotation, Position position, String text) {
		Graphics2D graphics = image.createGraphics();
		Graphics2DUtils.drawString(graphics, font, color, alphaComposite, renderingHints, rotation, position, text);
		graphics.dispose();
		return image;
	}

	/**
	 * Write text in image, save new image to provide path.
	 * @param image Original BufferedImage object.
	 * @param font Font object for String.
	 * @param color Color object for String.
	 * @param alphaComposite AlphaComposite object.
	 * @param renderingHints RenderingHints object.
	 * @param rotation Rotation object.
	 * @param position the coordinate of the location where the <code>text</code> should be rendered.
	 * @param text text need draw in Graphics2D.
	 * @param path Path for saving new image.
	 * @throws IOException from ImageIO.write
	 */
	public static void drawText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, Rotation rotation, Position position, String text, String path) throws IOException {
		BufferedImage bufferedImage = drawText(image, font, color, alphaComposite, renderingHints, rotation, position, text);
		BufferedImageUtils.write(bufferedImage, path);
	}

	/**
	 * Write text in image, return BufferedImage object with string.
	 * @param image Original BufferedImage object.
	 * @param font Font object for String.
	 * @param color Color object for String.
	 * @param alphaComposite AlphaComposite object.
	 * @param renderingHints RenderingHints object.
	 * @param rotation Rotation object.
	 * @param x the x coordinate of the location where the <code>text</code> should be rendered.
	 * @param y the y coordinate of the location where the <code>text</code> should be rendered.
	 * @param text text need draw in Graphics2D.
	 * @return BufferedImage
	 */
	public static BufferedImage drawText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, Rotation rotation, float x, float y, String text) {
		return drawText(image, font, color, alphaComposite, renderingHints, rotation, new Position(x, y), text);
	}

	/**
	 * Write text in image, save new image to provide path.
	 * @param image Original BufferedImage object.
	 * @param font Font object for String.
	 * @param color Color object for String.
	 * @param alphaComposite AlphaComposite object.
	 * @param renderingHints RenderingHints object.
	 * @param rotation Rotation object.
	 * @param x the x coordinate of the location where the <code>text</code> should be rendered.
	 * @param y the y coordinate of the location where the <code>text</code> should be rendered.
	 * @param text text need draw in Graphics2D.
	 * @param path Path for saving new image.
	 * @throws IOException from ImageIO.write
	 */
	public static void drawText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, Rotation rotation, float x, float y, String text, String path) throws IOException {
		BufferedImage bufferedImage = drawText(image, font, color, alphaComposite, renderingHints, rotation, x, y, text);
		BufferedImageUtils.write(bufferedImage, path);
	}

	/**
	 * Write text in image, return BufferedImage object with string.
	 * @param image Original BufferedImage object.
	 * @param font Font object for String.
	 * @param color Color object for String.
	 * @param alphaComposite AlphaComposite object.
	 * @param renderingHints RenderingHints object.
	 * @param rotator Rotator object to calculate Rotation object.
	 * @param positioner Positioner object to calculate Position object which is the coordinate of the location where the
	 *            <code>text</code> should be rendered.
	 * @param text text need draw in Graphics2D.
	 * @return BufferedImage
	 */
	public static BufferedImage drawText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, Rotator rotator, Positioner positioner, String text) {
		Graphics2D graphics = image.createGraphics();
		ImageFactor imageFactor = new ImageFactor(image.getWidth(), image.getHeight());
		Rotation rotation = null;

		if (rotator != null) {
			rotation = rotator.calculate(imageFactor);
		}

		Position position = positioner.calculate(imageFactor.getWidth(), imageFactor.getHeight(), graphics, font, text);
		Graphics2DUtils.drawString(graphics, font, color, alphaComposite, renderingHints, rotation, position, text);
		graphics.dispose();
		return image;
	}

	/**
	 * Write text in image, save new image to provide path.
	 * @param image Original BufferedImage object.
	 * @param font Font object for String.
	 * @param color Color object for String.
	 * @param alphaComposite AlphaComposite object.
	 * @param renderingHints RenderingHints object.
	 * @param rotator Rotator object to calculate Rotation object.
	 * @param positioner Positioner object to calculate Position object which is the coordinate of the location where the
	 *            <code>text</code> should be rendered.
	 * @param text text need draw in Graphics2D.
	 * @param path Path for saving new image.
	 * @throws IOException from ImageIO.write
	 */
	public static void drawText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, Rotator rotator, Positioner positioner, String text, String path) throws IOException {
		BufferedImage bufferedImage = drawText(image, font, color, alphaComposite, renderingHints, rotator, positioner, text);
		BufferedImageUtils.write(bufferedImage, path);
	}
}