package devutility.internal.awt.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import devutility.internal.awt.FontUtils;
import devutility.internal.awt.RenderingHintsUtils;
import devutility.internal.io.FileUtils;

public class WatermarkUtils {
	/**
	 * Add watermark in image, return BufferedImage object with watermark text.
	 * @param image Image object.
	 * @param text Watermark text.
	 * @param slopeAngle Watermark text slope angle, for example 45.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param positionX Position X for watermark in image.
	 * @param positionY Position Y for watermark in image.
	 * @param renderingHints RenderingHints object.
	 * @param alphaComposite AlphaComposite object.
	 * @return BufferedImage
	 */
	public static BufferedImage mark(Image image, String text, int slopeAngle, Font font, Color color, float positionX, float positionY, RenderingHints renderingHints, AlphaComposite alphaComposite) {
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = bufferedImage.createGraphics();
		graphics.setRenderingHints(renderingHints);
		graphics.drawImage(scaledImage, 0, 0, null);

		if (slopeAngle > 0) {
			graphics.rotate(Math.toRadians(slopeAngle), width / 2, height / 2);
		}

		graphics.setFont(font);
		graphics.setColor(color);
		graphics.setComposite(alphaComposite);
		graphics.drawString(text, positionX, positionY);
		graphics.dispose();
		return bufferedImage;
	}

	/**
	 * Add watermark in image, return BufferedImage object with watermark text.
	 * @param image Image object.
	 * @param text Watermark text.
	 * @param slopeAngle Watermark text slope angle, for example 45.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param positionX Position X for watermark in image.
	 * @param positionY Position Y for watermark in image.
	 * @param renderingHints RenderingHints object.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @return BufferedImage
	 */
	public static BufferedImage mark(Image image, String text, int slopeAngle, Font font, Color color, float positionX, float positionY, RenderingHints renderingHints, float alpha) {
		return mark(image, text, slopeAngle, font, color, positionX, positionY, renderingHints, AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
	}

	/**
	 * Add watermark in image, return BufferedImage object with watermark text.
	 * @param image Image object.
	 * @param text Watermark text.
	 * @param slopeAngle Watermark text slope angle, for example 45.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param positionX Position X for watermark in image.
	 * @param positionY Position Y for watermark in image.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @return BufferedImage
	 */
	public static BufferedImage mark(Image image, String text, int slopeAngle, Font font, Color color, float positionX, float positionY, float alpha) {
		return mark(image, text, slopeAngle, font, color, positionX, positionY, RenderingHintsUtils.highQuality(), alpha);
	}

	/**
	 * Add watermark in image, save the new image to provided imagePath.
	 * @param image Image object.
	 * @param text Watermark text.
	 * @param slopeAngle Watermark text slope angle, for example 45.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param positionX Position X for watermark in image.
	 * @param positionY Position Y for watermark in image.
	 * @param renderingHints RenderingHints object.
	 * @param alphaComposite AlphaComposite object.
	 * @param imagePath Path for new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void mark(Image image, String text, int slopeAngle, Font font, Color color, float positionX, float positionY, RenderingHints renderingHints, AlphaComposite alphaComposite, String imagePath)
			throws IOException {
		BufferedImage bufferedImage = mark(image, text, slopeAngle, font, color, positionX, positionY, renderingHints, alphaComposite);
		File file = new File(imagePath);
		String extension = FileUtils.getExtension(imagePath).substring(1);

		if (!ImageIO.write(bufferedImage, extension, file)) {
			throw new IOException(String.format("Write image failed! %s", imagePath));
		}
	}

	/**
	 * Add watermark in image, save the new image to provided imagePath.
	 * @param image Image object.
	 * @param text Watermark text.
	 * @param slopeAngle Watermark text slope angle, for example 45.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param positionX Position X for watermark in image.
	 * @param positionY Position Y for watermark in image.
	 * @param renderingHints RenderingHints object.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @param imagePath Path for new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void mark(Image image, String text, int slopeAngle, Font font, Color color, float positionX, float positionY, RenderingHints renderingHints, float alpha, String imagePath) throws IOException {
		mark(image, text, slopeAngle, font, color, positionX, positionY, renderingHints, AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha), imagePath);
	}

	/**
	 * Add watermark in image, save the new image to provided imagePath.
	 * @param image BufferedImage object.
	 * @param text Watermark text.
	 * @param slopeAngle Watermark text slope angle, for example 45.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param positionX Position X for watermark in image.
	 * @param positionY Position Y for watermark in image.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @param imagePath Path for new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void mark(Image image, String text, int slopeAngle, Font font, Color color, float positionX, float positionY, float alpha, String imagePath) throws IOException {
		mark(image, text, slopeAngle, font, color, positionX, positionY, RenderingHintsUtils.highQuality(), alpha, imagePath);
	}

	public static BufferedImage bottomRightMark(BufferedImage image, String text, Font font, Color color, RenderingHints renderingHints, AlphaComposite alphaComposite) {
		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImageUtils.getImageType(image));
		Graphics2D graphics = bufferedImage.createGraphics();
		graphics.setRenderingHints(renderingHints);
		graphics.drawImage(image, 0, 0, null);
		graphics.setFont(font);
		graphics.setColor(color);
		graphics.setComposite(alphaComposite);

		float[] position = getBottomRightPosition(width, height, graphics, font, text);
		graphics.drawString(text, position[0], position[1]);
		graphics.dispose();
		return bufferedImage;
	}

	public static BufferedImage bottomRightMark(BufferedImage image, String text, Font font, Color color, RenderingHints renderingHints, float alpha) {
		return bottomRightMark(image, text, font, color, renderingHints, AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
	}

	public static BufferedImage bottomRightMark(BufferedImage image, String text, Font font, Color color, float alpha) {
		return bottomRightMark(image, text, font, color, RenderingHintsUtils.highQuality(), alpha);
	}

	public static void bottomRightMark(BufferedImage image, String text, Font font, Color color, RenderingHints renderingHints, AlphaComposite alphaComposite, String imagePath) throws IOException {
		BufferedImage bufferedImage = bottomRightMark(image, text, font, color, renderingHints, alphaComposite);
		File file = new File(imagePath);
		String extension = FileUtils.getExtension(imagePath).substring(1);

		if (!ImageIO.write(bufferedImage, extension, file)) {
			throw new IOException(String.format("Write image failed! %s", imagePath));
		}
	}

	public static void bottomRightMark(BufferedImage image, String text, Font font, Color color, RenderingHints renderingHints, float alpha, String imagePath) throws IOException {
		bottomRightMark(image, text, font, color, renderingHints, AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha), imagePath);
	}

	public static void bottomRightMark(BufferedImage image, String text, Font font, Color color, float alpha, String imagePath) throws IOException {
		bottomRightMark(image, text, font, color, RenderingHintsUtils.highQuality(), alpha, imagePath);
	}

	private static float[] getBottomRightPosition(int imageWidth, int imageHeight, Graphics2D graphics, Font font, String text) {
		float xRightOffset = 15;
		float yBottomOffset = 15;
		int stringWidth = FontUtils.getStringWidth(graphics, font, text);

		float[] array = new float[2];
		array[0] = imageWidth - stringWidth - xRightOffset;
		array[1] = imageHeight - yBottomOffset;
		return array;
	}
}