package devutility.internal.awt.image;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class BufferedImageUtils {
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