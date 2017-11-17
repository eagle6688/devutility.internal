package devutility.internal.data.codec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipHelper {
	public static byte[] compress(byte[] bytes) throws Exception {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		byte[] compressedBytes;

		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
			try (GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
				gZIPOutputStream.write(bytes);
			} catch (Exception e) {
				throw e;
			}

			compressedBytes = byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			throw e;
		}

		return compressedBytes;
	}

	public static byte[] deCompress(byte[] bytes) throws Exception {
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
				} catch (Exception e) {
					throw e;
				}
			} catch (Exception e) {
				throw e;
			}

			deCompressedBytes = byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			throw e;
		}

		return deCompressedBytes;
	}
}