package devutility.internal.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import devutility.internal.data.codec.UTF8Utils;

public class HttpUtils extends BaseHttpUtils {
	/**
	 * Get data from url.
	 * @param url: Request Url.
	 * @return String
	 * @throws IOException
	 */
	public static String get(String url) throws IOException {
		return get(url, 0);
	}

	/**
	 * Get data from url.
	 * @param url: Request Url.
	 * @param timeout: Request timeout.
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
	 * Get data from url.
	 * @param url: Request Url.
	 * @param contentType: Content-Type in http request header.
	 * @param timeout: Request timeout.
	 * @return HttpResponse
	 * @throws IOException
	 */
	public static HttpResponse get(String url, String contentType, int timeout) throws IOException {
		HttpURLConnection httpURLConnection = httpURLConnection(url, "GET", contentType, timeout);
		return httpResponse(httpURLConnection);
	}

	/**
	 * Get Json data from url.
	 * @param url: Request Url.
	 * @return String
	 * @throws IOException
	 */
	public static String getJson(String url) throws IOException {
		return getJson(url, 0);
	}

	/**
	 * Get Json data from url.
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
	 * Post data to Url.
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
	 * Post data to Url.
	 * @param url: Request Url.
	 * @param contentType: Content-Type in http request header.
	 * @param data: Request data.
	 * @param timeout: Request timeout.
	 * @return HttpResponse
	 * @throws IOException
	 */
	public static HttpResponse post(String url, String contentType, byte[] data, int timeout) throws IOException {
		HttpURLConnection httpURLConnection = httpURLConnection(url, "POST", contentType, data, timeout);
		send(httpURLConnection, data);
		return httpResponse(httpURLConnection);
	}

	/**
	 * Post form data to Url.
	 * @param url: Request Url.
	 * @param data: Form data.
	 * @return String
	 * @throws IOException
	 */
	public static String postForm(String url, String data) throws IOException {
		return postForm(url, data, 0);
	}

	/**
	 * Post form data to Url.
	 * @param url: Request Url.
	 * @param data: Form data
	 * @param timeout: Request timeout.
	 * @return String
	 * @throws IOException
	 */
	public static String postForm(String url, String data, int timeout) throws IOException {
		return post(url, "application/x-www-form-urlencoded", data, timeout);
	}

	/**
	 * Post Json data to Url.
	 * @param url: Request Url.
	 * @param data: Json data.
	 * @return String
	 * @throws IOException
	 */
	public static String postJson(String url, String data) throws IOException {
		return postJson(url, data, 0);
	}

	/**
	 * Post Json data to Url.
	 * @param url: Request Url.
	 * @param data: Json data.
	 * @param timeout: Request timeout.
	 * @return String
	 * @throws IOException
	 */
	public static String postJson(String url, String data, int timeout) throws IOException {
		return post(url, "application/json", data, timeout);
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
		setHttpURLConnection(httpURLConnection, method, contentType, data, timeout);
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