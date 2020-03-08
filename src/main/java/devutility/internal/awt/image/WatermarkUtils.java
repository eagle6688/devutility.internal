package devutility.internal.awt.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import devutility.internal.awt.RenderingHintsUtils;
import devutility.internal.awt.position.Positioner;
import devutility.internal.awt.position.text.TextBottomRightPosition;
import devutility.internal.awt.position.text.TextCenterPosition;
import devutility.internal.awt.position.text.TextSlopeCenterPositioner;

public class WatermarkUtils {
	/**
	 * Add watermark in image, save the new image to provided imagePath.
	 * @param image Original BufferedImage object.
	 * @param text Watermark text.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param renderingHints RenderingHints object.
	 * @param alphaComposite AlphaComposite object.
	 * @param imagePath Path for new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void bottomRightText(BufferedImage image, String text, Font font, Color color, RenderingHints renderingHints, AlphaComposite alphaComposite, String imagePath) throws IOException {
		Positioner positioner = new TextBottomRightPosition(15f, 15f);
		ImageUtils.drawText(image, text, 0, font, color, positioner, renderingHints, alphaComposite, imagePath);
	}

	/**
	 * Add watermark in image, save the new image to provided imagePath.
	 * @param image Original BufferedImage object.
	 * @param text Watermark text.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param renderingHints RenderingHints object.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @param imagePath Path for new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void bottomRightText(BufferedImage image, String text, Font font, Color color, RenderingHints renderingHints, float alpha, String imagePath) throws IOException {
		bottomRightText(image, text, font, color, renderingHints, AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha), imagePath);
	}

	/**
	 * Add watermark in image, save the new image to provided imagePath.
	 * @param image Original BufferedImage object.
	 * @param text Watermark text.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @param imagePath Path for new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void bottomRightText(BufferedImage image, String text, Font font, Color color, float alpha, String imagePath) throws IOException {
		bottomRightText(image, text, font, color, RenderingHintsUtils.highQuality(), alpha, imagePath);
	}

	/**
	 * Add watermark in the center of image, save the new image to provide imagePath.
	 * @param image Original BufferedImage object.
	 * @param text Watermark text.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param renderingHints RenderingHints object.
	 * @param alphaComposite AlphaComposite object.
	 * @param imagePath Path for saving new image.
	 * @throws IOException from ImageUtils.drawText method.
	 */
	public static void centerText(BufferedImage image, String text, Font font, Color color, RenderingHints renderingHints, AlphaComposite alphaComposite, String imagePath) throws IOException {
		Positioner positioner = new TextCenterPosition();
		ImageUtils.drawText(image, text, 0, font, color, positioner, renderingHints, alphaComposite, imagePath);
	}

	/**
	 * Add watermark in the center of image, save the new image to provide imagePath.
	 * @param image Original BufferedImage object.
	 * @param text Watermark text.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param renderingHints RenderingHints object.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @param imagePath Path for saving new image.
	 * @throws IOException from ImageUtils.drawText method.
	 */
	public static void centerText(BufferedImage image, String text, Font font, Color color, RenderingHints renderingHints, float alpha, String imagePath) throws IOException {
		centerText(image, text, font, color, renderingHints, AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha), imagePath);
	}

	/**
	 * Add watermark in the center of image, save the new image to provide imagePath.
	 * @param image Original BufferedImage object.
	 * @param text Watermark text.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @param imagePath Path for saving new image.
	 * @throws IOException from ImageUtils.drawText method.
	 */
	public static void centerText(BufferedImage image, String text, Font font, Color color, float alpha, String imagePath) throws IOException {
		centerText(image, text, font, color, RenderingHintsUtils.highQuality(), alpha, imagePath);
	}

	public static void slopeCenterText(BufferedImage image, String text, Font font, Color color, RenderingHints renderingHints, AlphaComposite alphaComposite, String imagePath) throws IOException {
		Positioner positioner = new TextSlopeCenterPositioner();
		ImageUtils.drawText(image, text, 0, font, color, positioner, renderingHints, alphaComposite, imagePath);
	}

	public static void slopeCenterText(BufferedImage image, String text, Font font, Color color, RenderingHints renderingHints, float alpha, String imagePath) throws IOException {
		slopeCenterText(image, text, font, color, renderingHints, AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha), imagePath);
	}

	public static void slopeCenterText(BufferedImage image, String text, Font font, Color color, float alpha, String imagePath) throws IOException {
		slopeCenterText(image, text, font, color, RenderingHintsUtils.highQuality(), alpha, imagePath);
	}
}