package devutility.internal.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import devutility.internal.data.codec.UTF8Utils;
import devutility.internal.lang.StringHelper;

public class HttpUtils extends BaseUtils {
	/**
	 * Get content from url.
	 * @param url: Request Url.
	 * @return String
	 * @throws IOException
	 */
	public static String get(String url) throws IOException {
		return get(url, 0);
	}

	/**
	 * Get content from url.
	 * @param url: Request Url.
	 * @param timeout: Timeout
	 * @return String
	 * @throws IOException
	 */
	public static String get(String url, int timeout) throws IOException {
		HttpResponse httpResponse = get(url, null, timeout);

		if (httpResponse == null) {
			return null;
		}

		return httpResponse.getResponse();
	}

	/**
	 * Get content from url.
	 * @param url: Request Url.
	 * @param contentType: Content-Type in http request header.
	 * @param timeout: Request timeout.
	 * @return HttpResponse
	 * @throws IOException
	 */
	public static HttpResponse get(String url, String contentType, int timeout) throws IOException {
		HttpURLConnection httpURLConnection = httpURLConnection(url, "GET", contentType, timeout);
		return getHttpResponse(httpURLConnection);
	}

	/**
	 * Get json from url.
	 * @param url: Request Url.
	 * @param timeout: Request timeout.
	 * @return String
	 * @throws IOException
	 */
	public static String getJson(String url, int timeout) throws IOException {
		HttpResponse httpResponse = get(url, "application/json", timeout);

		if (httpResponse == null) {
			return null;
		}

		return httpResponse.getResponse();
	}

	/**
	 * Get json from url.
	 * @param url: Request Url.
	 * @return String
	 * @throws IOException
	 */
	public static String getJson(String url) throws IOException {
		return getJson(url, 0);
	}

	/**
	 * Post form data
	 * @param url: Request Url.
	 * @param data: Form data.
	 * @return String
	 * @throws IOException
	 */
	public static String postForm(String url, String data) throws IOException {
		return postForm(url, data, 0);
	}

	/**
	 * Post form data with timeout limitation.
	 * @param url: Request Url.
	 * @param data: Request form data
	 * @param timeout: Request timeout.
	 * @return String
	 * @throws IOException
	 */
	public static String postForm(String url, String data, int timeout) throws IOException {
		return post(url, "application/x-www-form-urlencoded", data, timeout);
	}

	/**
	 * Post json data.
	 * @param url: Request Url.
	 * @param data: Request json data
	 * @return String
	 * @throws IOException
	 */
	public static String postJson(String url, String data) throws IOException {
		return postJson(url, data, 0);
	}

	/**
	 * Post json data
	 * @param url: Request Url.
	 * @param data: Request json data
	 * @param timeout: Request timeout.
	 * @return String
	 * @throws IOException
	 */
	public static String postJson(String url, String data, int timeout) throws IOException {
		return post(url, "application/json", data, timeout);
	}

	/**
	 * Post data to Url
	 * @param url: Request Url.
	 * @param contentType: Content-Type in http request header.
	 * @param data: Request data.
	 * @param timeout: Request timeout.
	 * @return String
	 * @throws IOException
	 */
	public static String post(String url, String contentType, String data, int timeout) throws IOException {
		HttpResponse httpResponse = post(url, contentType, UTF8Utils.encode(data), timeout);

		if (httpResponse == null) {
			return null;
		}

		return httpResponse.getResponse();
	}

	/**
	 * Post
	 * @param url: Request Url.
	 * @param contentType: Content-Type in http request header.
	 * @param data: Request data.
	 * @param timeout: Request timeout.
	 * @return HttpResponse
	 * @throws IOException
	 */
	public static HttpResponse post(String url, String contentType, byte[] data, int timeout) throws IOException {
		HttpURLConnection httpURLConnection = httpURLConnection(url, "POST", contentType, data, timeout);

		try (OutputStream outputStream = httpURLConnection.getOutputStream()) {
			outputStream.write(data);
		} catch (IOException e) {
			throw e;
		}

		return getHttpResponse(httpURLConnection);
	}

	/**
	 * Create a HttpURLConnection instance.
	 * @param url: Request Url.
	 * @param method: Request method, GET or POST.
	 * @param contentType: Content-Type in http request header.
	 * @param data: Request data if method is "POST".
	 * @param timeout: Request timeout.
	 * @return HttpURLConnection
	 * @throws IOException
	 */
	private static HttpURLConnection httpURLConnection(URL url, String method, String contentType, byte[] data, int timeout) throws IOException {
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setUseCaches(false);
		httpURLConnection.setRequestProperty("charset", "utf-8");

		if (StringHelper.isNullOrEmpty(method)) {
			method = "GET";
		}

		httpURLConnection.setRequestMethod(method);

		if (!StringHelper.isNullOrEmpty(contentType)) {
			httpURLConnection.setRequestProperty("content-Type", contentType);
		}

		if (method.equals("POST") && data != null) {
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestProperty("Content-length", String.valueOf(data.length));
		}

		if (timeout > 0) {
			httpURLConnection.setConnectTimeout(timeout);
			httpURLConnection.setReadTimeout(timeout);
		}

		return httpURLConnection;
	}

	/**
	 * Create a HttpURLConnection instance.
	 * @param url: Request Url.
	 * @param method: Request method, GET or POST.
	 * @param contentType: Content-Type in http request header.
	 * @param data: Request data if method is "POST".
	 * @param timeout: Request timeout.
	 * @return HttpURLConnection
	 * @throws IOException
	 */
	private static HttpURLConnection httpURLConnection(String url, String method, String contentType, byte[] data, int timeout) throws IOException {
		URL urlObj = new URL(url);
		return httpURLConnection(urlObj, method, contentType, data, timeout);
	}

	/**
	 * Create a HttpURLConnection instance.
	 * @param url: Request Url.
	 * @param method: Request method, GET or POST.
	 * @param contentType: Content-Type in http request header.
	 * @param timeout: Request timeout.
	 * @return HttpURLConnection
	 * @throws IOException
	 */
	private static HttpURLConnection httpURLConnection(String url, String method, String contentType, int timeout) throws IOException {
		return httpURLConnection(url, method, contentType, null, timeout);
	}
}