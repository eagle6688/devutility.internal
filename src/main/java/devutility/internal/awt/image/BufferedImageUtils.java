package devutility.internal.awt.image;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

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
}