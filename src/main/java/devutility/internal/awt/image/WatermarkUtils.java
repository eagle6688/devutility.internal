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
import devutility.internal.awt.rotation.Rotator;
import devutility.internal.awt.rotation.text.TextSlopeCenterRotator;

/**
 * 
 * WatermarkUtils
 * 
 * @author: Aldwin Su
 * @creation: 2019-03-17 16:26:05
 */
public class WatermarkUtils {
	/**
	 * Add watermark in bottom right of image, save new image to provide path.
	 * @param image Original BufferedImage object.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param alphaComposite AlphaComposite object.
	 * @param renderingHints RenderingHints object.
	 * @param text Watermark text.
	 * @param path Path for new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void bottomRightText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, String text, String path) throws IOException {
		Positioner positioner = new TextBottomRightPosition(15f, 15f);
		ImageUtils.drawText(image, font, color, alphaComposite, renderingHints, null, positioner, text, path);
	}

	/**
	 * Add watermark in bottom right of image, save new image to provide path.
	 * @param image Original BufferedImage object.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @param renderingHints RenderingHints object.
	 * @param text Watermark text.
	 * @param path Path for new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void bottomRightText(BufferedImage image, Font font, Color color, float alpha, RenderingHints renderingHints, String text, String path) throws IOException {
		AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		bottomRightText(image, font, color, alphaComposite, renderingHints, text, path);
	}

	/**
	 * Add watermark in bottom right of image, save new image to provide path.
	 * @param image Original BufferedImage object.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @param text Watermark text.
	 * @param path Path for new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void bottomRightText(BufferedImage image, Font font, Color color, float alpha, String text, String path) throws IOException {
		bottomRightText(image, font, color, alpha, RenderingHintsUtils.highQuality(), text, path);
	}

	/**
	 * Add watermark in the center of image, save new image to provide path.
	 * @param image Original BufferedImage object.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param alphaComposite AlphaComposite object.
	 * @param renderingHints RenderingHints object.
	 * @param text Watermark text.
	 * @param path Path for saving new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void centerText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, String text, String path) throws IOException {
		Positioner positioner = new TextCenterPosition();
		ImageUtils.drawText(image, font, color, alphaComposite, renderingHints, null, positioner, text, path);
	}

	/**
	 * Add watermark in the center of image, save new image to provide path.
	 * @param image Original BufferedImage object.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @param renderingHints RenderingHints object.
	 * @param text Watermark text.
	 * @param path Path for saving new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void centerText(BufferedImage image, Font font, Color color, float alpha, RenderingHints renderingHints, String text, String path) throws IOException {
		AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		centerText(image, font, color, alphaComposite, renderingHints, text, path);
	}

	/**
	 * Add watermark in the center of image, save new image to provide path.
	 * @param image Original BufferedImage object.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @param text Watermark text.
	 * @param path Path for saving new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void centerText(BufferedImage image, Font font, Color color, float alpha, String text, String path) throws IOException {
		centerText(image, font, color, alpha, RenderingHintsUtils.highQuality(), text, path);
	}

	/**
	 * Add watermark in the center slope line of image, save new image to provide path.
	 * @param image Original BufferedImage object.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param alphaComposite AlphaComposite object.
	 * @param renderingHints RenderingHints object.
	 * @param text Watermark text.
	 * @param path Path for saving new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void slopeCenterText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, String text, String path) throws IOException {
		Rotator rotator = new TextSlopeCenterRotator();
		Positioner positioner = new TextSlopeCenterPositioner();
		ImageUtils.drawText(image, font, color, alphaComposite, renderingHints, rotator, positioner, text, path);
	}

	/**
	 * Add watermark in the center slope line of image, save new image to provide path.
	 * @param image Original BufferedImage object.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @param renderingHints RenderingHints object.
	 * @param text Watermark text.
	 * @param path Path for saving new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void slopeCenterText(BufferedImage image, Font font, Color color, float alpha, RenderingHints renderingHints, String text, String path) throws IOException {
		AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		slopeCenterText(image, font, color, alphaComposite, renderingHints, text, path);
	}

	/**
	 * Add watermark in the center slope line of image, save new image to provide path.
	 * @param image Original BufferedImage object.
	 * @param font Font object for watermark.
	 * @param color Color object for watermark.
	 * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
	 * @param text Watermark text.
	 * @param path Path for saving new image.
	 * @throws IOException Throw when File not found or writed failed.
	 */
	public static void slopeCenterText(BufferedImage image, Font font, Color color, float alpha, String text, String path) throws IOException {
		slopeCenterText(image, font, color, alpha, RenderingHintsUtils.highQuality(), text, path);
	}
}