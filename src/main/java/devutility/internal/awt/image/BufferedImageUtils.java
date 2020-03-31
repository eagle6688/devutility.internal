package devutility.internal.awt.image;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import devutility.internal.io.FileUtils;

/**
 * 
 * BufferedImageUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-03-17 16:26:05
 */
public class BufferedImageUtils {
	/**
	 * Get suitable ImageType for drawing.
	 * @param bufferedImage BufferedImage object.
	 * @return int
	 */
	public static int getImageType(BufferedImage bufferedImage) {
		if (bufferedImage.getColorModel().hasAlpha()) {
			return BufferedImage.TYPE_INT_ARGB;
		}

		return BufferedImage.TYPE_INT_RGB;
	}

	/**
	 * Convert BufferedImage to bytes array.
	 * @param bufferedImage BufferedImage object.
	 * @return byte[]
	 */
	public static byte[] toBytes(BufferedImage bufferedImage) {
		DataBufferByte dataBuffer = (DataBufferByte) bufferedImage.getRaster().getDataBuffer();
		return dataBuffer.getData();
	}

	/**
	 * Write BufferedImage object to local path.
	 * @param image BufferedImage object.
	 * @param path Path for saving new image.
	 * @throws IOException from ImageIO.write
	 */
	public static void write(BufferedImage image, String path) throws IOException {
		String extension = FileUtils.getExtension(path).substring(1);
		File file = new File(path);

		if (!ImageIO.write(image, extension, file)) {
			throw new IOException(String.format("Failed write image to %s", path));
		}
	}
}