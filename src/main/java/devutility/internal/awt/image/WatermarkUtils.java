package devutility.internal.awt.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import devutility.internal.awt.FontUtils;
import devutility.internal.awt.RenderingHintsUtils;
import devutility.internal.awt.position.Position;
import devutility.internal.awt.position.Positioner;
import devutility.internal.awt.position.text.TextBottomRightPosition;
import devutility.internal.awt.position.text.TextCenterPosition;
import devutility.internal.awt.position.text.TextSlopeCenterPositioner;
import devutility.internal.awt.rotation.Rotation;
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
     * 
     * @param image          Original BufferedImage object.
     * @param font           Font object for watermark.
     * @param color          Color object for watermark.
     * @param alphaComposite AlphaComposite object.
     * @param renderingHints RenderingHints object.
     * @param text           Watermark text.
     * @param path           Path for new image.
     * @throws IOException Throw when File not found or writed failed.
     */
    public static void bottomRightText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, String text, String path) throws IOException {
        Positioner positioner = new TextBottomRightPosition(15f, 15f);
        ImageUtils.drawText(image, font, color, alphaComposite, renderingHints, null, positioner, text, path);
    }

    /**
     * Add watermark in bottom right of image, save new image to provide path.
     * 
     * @param image          Original BufferedImage object.
     * @param font           Font object for watermark.
     * @param color          Color object for watermark.
     * @param alpha          Alpha percentage in float, range from 0 to 1f, for example 0.5f.
     * @param renderingHints RenderingHints object.
     * @param text           Watermark text.
     * @param path           Path for new image.
     * @throws IOException Throw when File not found or writed failed.
     */
    public static void bottomRightText(BufferedImage image, Font font, Color color, float alpha, RenderingHints renderingHints, String text, String path) throws IOException {
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        bottomRightText(image, font, color, alphaComposite, renderingHints, text, path);
    }

    /**
     * Add watermark in bottom right of image, save new image to provide path.
     * 
     * @param image Original BufferedImage object.
     * @param font  Font object for watermark.
     * @param color Color object for watermark.
     * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
     * @param text  Watermark text.
     * @param path  Path for new image.
     * @throws IOException Throw when File not found or writed failed.
     */
    public static void bottomRightText(BufferedImage image, Font font, Color color, float alpha, String text, String path) throws IOException {
        bottomRightText(image, font, color, alpha, RenderingHintsUtils.highQuality(), text, path);
    }

    /**
     * Add watermark in the center of image, save new image to provide path.
     * 
     * @param image          Original BufferedImage object.
     * @param font           Font object for watermark.
     * @param color          Color object for watermark.
     * @param alphaComposite AlphaComposite object.
     * @param renderingHints RenderingHints object.
     * @param text           Watermark text.
     * @param path           Path for saving new image.
     * @throws IOException Throw when File not found or writed failed.
     */
    public static void centerText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, String text, String path) throws IOException {
        Positioner positioner = new TextCenterPosition();
        ImageUtils.drawText(image, font, color, alphaComposite, renderingHints, null, positioner, text, path);
    }

    /**
     * Add watermark in the center of image, save new image to provide path.
     * 
     * @param image          Original BufferedImage object.
     * @param font           Font object for watermark.
     * @param color          Color object for watermark.
     * @param alpha          Alpha percentage in float, range from 0 to 1f, for example 0.5f.
     * @param renderingHints RenderingHints object.
     * @param text           Watermark text.
     * @param path           Path for saving new image.
     * @throws IOException Throw when File not found or writed failed.
     */
    public static void centerText(BufferedImage image, Font font, Color color, float alpha, RenderingHints renderingHints, String text, String path) throws IOException {
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        centerText(image, font, color, alphaComposite, renderingHints, text, path);
    }

    /**
     * Add watermark in the center of image, save new image to provide path.
     * 
     * @param image Original BufferedImage object.
     * @param font  Font object for watermark.
     * @param color Color object for watermark.
     * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
     * @param text  Watermark text.
     * @param path  Path for saving new image.
     * @throws IOException Throw when File not found or writed failed.
     */
    public static void centerText(BufferedImage image, Font font, Color color, float alpha, String text, String path) throws IOException {
        centerText(image, font, color, alpha, RenderingHintsUtils.highQuality(), text, path);
    }

    /**
     * Add watermark in the center slope line of image, save new image to provide path.
     * 
     * @param image          Original BufferedImage object.
     * @param font           Font object for watermark.
     * @param color          Color object for watermark.
     * @param alphaComposite AlphaComposite object.
     * @param renderingHints RenderingHints object.
     * @param text           Watermark text.
     * @param path           Path for saving new image.
     * @throws IOException Throw when File not found or writed failed.
     */
    public static void slopeCenterText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, String text, String path) throws IOException {
        Rotator rotator = new TextSlopeCenterRotator();
        Positioner positioner = new TextSlopeCenterPositioner();
        ImageUtils.drawText(image, font, color, alphaComposite, renderingHints, rotator, positioner, text, path);
    }

    /**
     * Add watermark in the center slope line of image, save new image to provide path.
     * 
     * @param image          Original BufferedImage object.
     * @param font           Font object for watermark.
     * @param color          Color object for watermark.
     * @param alpha          Alpha percentage in float, range from 0 to 1f, for example 0.5f.
     * @param renderingHints RenderingHints object.
     * @param text           Watermark text.
     * @param path           Path for saving new image.
     * @throws IOException Throw when File not found or writed failed.
     */
    public static void slopeCenterText(BufferedImage image, Font font, Color color, float alpha, RenderingHints renderingHints, String text, String path) throws IOException {
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        slopeCenterText(image, font, color, alphaComposite, renderingHints, text, path);
    }

    /**
     * Add watermark in the center slope line of image, save new image to provide path.
     * 
     * @param image Original BufferedImage object.
     * @param font  Font object for watermark.
     * @param color Color object for watermark.
     * @param alpha Alpha percentage in float, range from 0 to 1f, for example 0.5f.
     * @param text  Watermark text.
     * @param path  Path for saving new image.
     * @throws IOException Throw when File not found or writed failed.
     */
    public static void slopeCenterText(BufferedImage image, Font font, Color color, float alpha, String text, String path) throws IOException {
        slopeCenterText(image, font, color, alpha, RenderingHintsUtils.highQuality(), text, path);
    }

    /**
     * Add multiple parallel watermarks in slope line direction of image, save new image to provided path.
     * 
     * @param image           Original BufferedImage object.
     * @param font            Font object for watermark.
     * @param color           Color object for watermark.
     * @param alphaComposite  AlphaComposite object.
     * @param renderingHints  RenderingHints object.
     * @param text            Watermark text.
     * @param parallelCount   Number of parallel watermarks.
     * @param parallelSpacing Spacing between adjacent parallel watermarks in pixel.
     * @param path            Path for saving new image.
     * @throws IOException Throw when File not found or writed failed.
     */
    public static void slopeText(BufferedImage image, Font font, Color color, AlphaComposite alphaComposite, RenderingHints renderingHints, String text, int parallelCount, float parallelSpacing, String path) throws IOException {
        if (parallelCount <= 0) {
            throw new IllegalArgumentException("parallelCount must be greater than 0.");
        }

        if (parallelSpacing <= 0) {
            throw new IllegalArgumentException("parallelSpacing must be greater than 0.");
        }

        Rotator rotator = new TextSlopeCenterRotator();
        Positioner positioner = new TextSlopeCenterPositioner();
        ImageFactor imageFactor = new ImageFactor(image.getWidth(), image.getHeight());
        Rotation rotation = rotator.calculate(imageFactor);
        Graphics2D graphics = image.createGraphics();
        Position centerPosition = positioner.calculate(imageFactor, graphics, font, text);
		float textWidth = FontUtils.getWidth(graphics, font, text);
        graphics.dispose();

        double radians = imageFactor.getDiagonalRadians();
		float directionX = (float) Math.cos(radians);
		float directionY = (float) Math.sin(radians);
        float perpendicularX = (float) -Math.sin(radians);
        float perpendicularY = (float) Math.cos(radians);
		float textSpacing = textWidth + parallelSpacing;
		int textCountPerLine = (int) Math.ceil(imageFactor.getDiagonal() / textSpacing) + 1;
		float maxPerpendicularDistance = maxPerpendicularDistance(centerPosition, imageFactor.getWidth(), imageFactor.getHeight(), perpendicularX, perpendicularY);
		int requiredParallelCount = (int) (Math.ceil(maxPerpendicularDistance / parallelSpacing) * 2 + 1);
		int actualParallelCount = Math.max(parallelCount, requiredParallelCount);
		double centerIndex = (actualParallelCount - 1) / 2.0;

		for (int index = 0; index < actualParallelCount; index++) {
            double currentOffset = (index - centerIndex) * parallelSpacing;
			float baseX = centerPosition.getX() + (float) currentOffset * perpendicularX;
			float baseY = centerPosition.getY() + (float) currentOffset * perpendicularY;

			for (int textIndex = -textCountPerLine; textIndex <= textCountPerLine; textIndex++) {
				float textOffset = textIndex * textSpacing;
				float x = baseX + textOffset * directionX;
				float y = baseY + textOffset * directionY;
				ImageUtils.drawText(image, font, color, alphaComposite, renderingHints, rotation, x, y, text);
			}
        }

        BufferedImageUtils.write(image, path);
    }

	private static float maxPerpendicularDistance(Position centerPosition, int imageWidth, int imageHeight, float perpendicularX, float perpendicularY) {
		float maxDistance = 0f;
		float[][] corners = new float[][] {
				{ 0f, 0f },
				{ imageWidth, 0f },
				{ 0f, imageHeight },
				{ imageWidth, imageHeight } };

		for (float[] corner : corners) {
			float xDistance = corner[0] - centerPosition.getX();
			float yDistance = corner[1] - centerPosition.getY();
			float distance = Math.abs(xDistance * perpendicularX + yDistance * perpendicularY);

			if (distance > maxDistance) {
				maxDistance = distance;
			}
		}

		return maxDistance;
	}

    /**
     * Add multiple parallel watermarks in slope line direction of image, save new image to provided path.
     * 
     * @param image           Original BufferedImage object.
     * @param font            Font object for watermark.
     * @param color           Color object for watermark.
     * @param alpha           Alpha percentage in float, range from 0 to 1f, for example 0.5f.
     * @param renderingHints  RenderingHints object.
     * @param text            Watermark text.
     * @param parallelCount   Number of parallel watermarks.
     * @param parallelSpacing Spacing between adjacent parallel watermarks in pixel.
     * @param path            Path for saving new image.
     * @throws IOException Throw when File not found or writed failed.
     */
    public static void slopeText(BufferedImage image, Font font, Color color, float alpha, RenderingHints renderingHints, String text, int parallelCount, float parallelSpacing, String path) throws IOException {
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        slopeText(image, font, color, alphaComposite, renderingHints, text, parallelCount, parallelSpacing, path);
    }

    /**
     * Add multiple parallel watermarks in slope line direction of image, save new image to provided path.
     * 
     * @param image           Original BufferedImage object.
     * @param font            Font object for watermark.
     * @param color           Color object for watermark.
     * @param alpha           Alpha percentage in float, range from 0 to 1f, for example 0.5f.
     * @param text            Watermark text.
     * @param parallelCount   Number of parallel watermarks.
     * @param parallelSpacing Spacing between adjacent parallel watermarks in pixel.
     * @param path            Path for saving new image.
     * @throws IOException Throw when File not found or writed failed.
     */
    public static void slopeText(BufferedImage image, Font font, Color color, float alpha, String text, int parallelCount, float parallelSpacing, String path) throws IOException {
        slopeText(image, font, color, alpha, RenderingHintsUtils.highQuality(), text, parallelCount, parallelSpacing, path);
    }
}