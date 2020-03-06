package devutility.internal.awt.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import devutility.internal.awt.Graphics2DUtils;
import devutility.internal.awt.position.Positioner;
import devutility.internal.io.FileUtils;
import devutility.internal.models.Position;

public class ImageUtils {
	/**
	 * Create a new image workspace.
	 * @param image BufferedImage object。
	 * @param renderingHints RenderingHints object.
	 * @return ImageSpace
	 */
	public static ImageSpace createImageSpace(BufferedImage image, RenderingHints renderingHints) {
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImageUtils.getImageType(image));

		ImageSpace imageSpace = new ImageSpace();
		imageSpace.setImage(bufferedImage);

		Graphics2D graphics = bufferedImage.createGraphics();
		graphics.setRenderingHints(renderingHints);
		graphics.drawImage(image, 0, 0, null);
		imageSpace.setGraphics2D(graphics);

		return imageSpace;
	}

	/**
	 * Write string in image, return BufferedImage object with string.
	 * @param image Original BufferedImage object.
	 * @param text String value.
	 * @param slopeAngle String slope angle, for example 45.
	 * @param font Font object for String.
	 * @param color Color object for String.
	 * @param positionX Position X for String in image.
	 * @param positionY Position Y for String in image.
	 * @param renderingHints RenderingHints object.
	 * @param alphaComposite AlphaComposite object.
	 * @return BufferedImage
	 */
	public static BufferedImage drawString(BufferedImage image, String text, int slopeAngle, Font font, Color color, float positionX, float positionY, RenderingHints renderingHints, AlphaComposite alphaComposite) {
		Graphics2D graphics = image.createGraphics();
		graphics.setRenderingHints(renderingHints);

		Graphics2DUtils.rotate(graphics, image.getWidth(), image.getHeight(), slopeAngle);
		Graphics2DUtils.drawString(graphics, font, color, alphaComposite, text, positionX, positionY);
		graphics.dispose();
		return image;
	}

	/**
	 * Write string in image, save the new image to provided imagePath.
	 * @param image Original BufferedImage object.
	 * @param text String value.
	 * @param slopeAngle String slope angle, for example 45.
	 * @param font Font object for String.
	 * @param color Color object for String.
	 * @param positionX Position X for String in image.
	 * @param positionY Position Y for String in image.
	 * @param renderingHints RenderingHints object.
	 * @param alphaComposite AlphaComposite object.
	 * @param imagePath Path for new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void drawString(BufferedImage image, String text, int slopeAngle, Font font, Color color, float positionX, float positionY, RenderingHints renderingHints, AlphaComposite alphaComposite, String imagePath) throws IOException {
		BufferedImage bufferedImage = drawString(image, text, 0, font, color, positionX, positionY, renderingHints, alphaComposite);
		File file = new File(imagePath);
		String extension = FileUtils.getExtension(imagePath).substring(1);

		if (!ImageIO.write(bufferedImage, extension, file)) {
			throw new IOException(String.format("Write image failed! %s", imagePath));
		}
	}

	/**
	 * Write string in image, return BufferedImage object with string.
	 * @param image Original BufferedImage object.
	 * @param text String value.
	 * @param slopeAngle String slope angle, for example 45.
	 * @param font Font object for String.
	 * @param color Color object for String.
	 * @param positioner Positioner implementation for getting position.
	 * @param renderingHints RenderingHints object.
	 * @param alphaComposite AlphaComposite object.
	 * @return BufferedImage
	 */
	public static BufferedImage drawString(BufferedImage image, String text, int slopeAngle, Font font, Color color, Positioner positioner, RenderingHints renderingHints, AlphaComposite alphaComposite) {
		Graphics2D graphics = image.createGraphics();
		graphics.setRenderingHints(renderingHints);

		Graphics2DUtils.rotate(graphics, image.getWidth(), image.getHeight(), slopeAngle);
		Position position = positioner.calculate(image, graphics, font, text);
		Graphics2DUtils.drawString(graphics, font, color, alphaComposite, text, position.getX(), position.getY());
		graphics.dispose();
		return image;
	}

	/**
	 * Write string in image, save the new image to provided imagePath.
	 * @param image Original BufferedImage object.
	 * @param text String value.
	 * @param slopeAngle String slope angle, for example 45.
	 * @param font Font object for String.
	 * @param color Color object for String.
	 * @param positioner Positioner implementation for getting position.
	 * @param renderingHints RenderingHints object.
	 * @param alphaComposite AlphaComposite object.
	 * @param imagePath Path for new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void drawString(BufferedImage image, String text, int slopeAngle, Font font, Color color, Positioner positioner, RenderingHints renderingHints, AlphaComposite alphaComposite, String imagePath) throws IOException {
		BufferedImage bufferedImage = ImageUtils.drawString(image, text, slopeAngle, font, color, positioner, renderingHints, alphaComposite);
		File file = new File(imagePath);
		String extension = FileUtils.getExtension(imagePath).substring(1);

		if (!ImageIO.write(bufferedImage, extension, file)) {
			throw new IOException(String.format("Write image failed! %s", imagePath));
		}
	}
}