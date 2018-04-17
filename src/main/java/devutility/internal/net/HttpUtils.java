package devutility.internal.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import devutility.internal.data.codec.UTF8Helper;
import devutility.internal.io.StreamHelper;

public class HttpUtils {
	/**
	 * Get content from url.
	 * @param url: Url of content.
	 * @return String
	 * @throws IOException
	 */
	public static String get(String url) throws IOException {
		return get(url, 0);
	}

	/**
	 * Get content from url.
	 * @param url: Url of content.
	 * @param timeout: Timeout
	 * @return String
	 * @throws IOException
	 */
	public static String get(String url, int timeout) throws IOException {
		byte[] bytes = null;
		URL urlObj = new URL(url);
		HttpURLConnection httpURLConnection = createHttpURLConnection(urlObj, timeout);

		try (InputStream inputStream = httpURLConnection.getInputStream()) {
			bytes = StreamHelper.read(inputStream);
		} catch (IOException e) {
			throw e;
		}

		return UTF8Helper.decode(bytes);
	}

	// region post

	public static String postForm(String url, String data, int timeout) {
		return post(url, data, "application/x-www-form-urlencoded", timeout);
	}

	public static String postJson(String url, String data) {
		return postJson(url, data);
	}

	public static String postJson(String url, String data, int timeout) {
		return post(url, data, "application/json", timeout);
	}

	public static String post(String url, String data, String contentType, int timeout) {
		try {
			return post(url, UTF8Helper.encode(data), contentType, timeout);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String post(String url, byte[] data, String contentType, int timeout) {
		String content = null;
		byte[] bytes = null;

		try {
			URL urlObj = new URL(url);
			HttpURLConnection httpURLConnection = createHttpURLConnection(urlObj, "POST");
			httpURLConnection.setDoOutput(true);

			httpURLConnection.setRequestProperty("content-Type", contentType);
			httpURLConnection.setRequestProperty("charset", "utf-8");
			httpURLConnection.setRequestProperty("Content-length", String.valueOf(data.length));

			try (OutputStream outputStream = httpURLConnection.getOutputStream()) {
				outputStream.write(data);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try (InputStream inputStream = httpURLConnection.getInputStream()) {
				bytes = StreamHelper.read(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (bytes == null) {
			return content;
		}

		try {
			content = UTF8Helper.decode(bytes);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return content;
	}

	// endregion

	// region create HttpURLConnection

	private static HttpURLConnection createHttpURLConnection(URL url, String method, int timeoutMilliseconds) throws IOException {
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setUseCaches(false);

		if (method != null) {
			httpURLConnection.setRequestMethod(method);
		}

		if (timeoutMilliseconds > 0) {
			httpURLConnection.setConnectTimeout(timeoutMilliseconds);
			httpURLConnection.setReadTimeout(timeoutMilliseconds);
		}

		return httpURLConnection;
	}

	private static HttpURLConnection createHttpURLConnection(URL url, String method) throws IOException {
		return createHttpURLConnection(url, method, 0);
	}

	private static HttpURLConnection createHttpURLConnection(URL url, int timeout) throws IOException {
		return createHttpURLConnection(url, null, timeout);
	}

	// endregion
}