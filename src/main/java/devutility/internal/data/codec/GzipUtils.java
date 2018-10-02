package devutility.internal.data.codec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtils {
	public static byte[] compress(byte[] bytes) throws IOException {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		byte[] compressedBytes;

		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
			try (GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
				gZIPOutputStream.write(bytes);
			} catch (IOException e) {
				throw e;
			}

			compressedBytes = byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			throw e;
		}

		return compressedBytes;
	}

	public static byte[] deCompress(byte[] bytes) throws IOException {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		byte[] deCompressedBytes;

		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
			try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes)) {
				try (GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream)) {
					int readCount = 0;
					byte[] buffer = new byte[1024];

					while ((readCount = gZIPInputStream.read(buffer)) >= 0) {
						byteArrayOutputStream.write(buffer, 0, readCount);
					}
				} catch (IOException e) {
					throw e;
				}
			} catch (IOException e) {
				throw e;
			}

			deCompressedBytes = byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			throw e;
		}

		return deCompressedBytes;
	}
}