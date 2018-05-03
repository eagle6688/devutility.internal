package devutility.internal.net;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

import devutility.internal.data.codec.UTF8Utils;
import devutility.internal.lang.StringHelper;

public class HttpsUtils extends BaseUtils {
	public static String get(String url, String protocol) throws KeyManagementException, NoSuchAlgorithmException, IOException {
		return get(url, protocol, 0);
	}

	public static String get(String url, String protocol, int timeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		HttpResponse httpResponse = get(url, null, protocol, timeout);

		if (httpResponse == null) {
			return null;
		}

		return httpResponse.getResponse();
	}

	public static String getJson(String url, String protocol) throws KeyManagementException, NoSuchAlgorithmException, IOException {
		return getJson(url, protocol, 0);
	}

	public static String getJson(String url, String protocol, int timeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		HttpResponse httpResponse = get(url, "application/json", protocol, timeout);

		if (httpResponse == null) {
			return null;
		}

		return httpResponse.getResponse();
	}

	public static HttpResponse get(String url, String contentType, String protocol, int timeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		HttpsURLConnection httpsURLConnection = httpsURLConnection(url, "GET", contentType, protocol, timeout);
		return getHttpResponse(httpsURLConnection);
	}

	public static String postForm(String url, String data, String protocol) throws KeyManagementException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
		return postForm(url, data, protocol, 0);
	}

	public static String postForm(String url, String data, String protocol, int timeout) throws KeyManagementException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
		return post(url, "application/x-www-form-urlencoded", data, protocol, timeout);
	}

	public static String postJson(String url, String data, String protocol) throws KeyManagementException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
		return postJson(url, data, protocol, 0);
	}

	public static String postJson(String url, String data, String protocol, int timeout) throws KeyManagementException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
		return post(url, "application/json", data, protocol, timeout);
	}

	public static String post(String url, String contentType, String data, String protocol, int timeout) throws KeyManagementException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
		HttpResponse httpResponse = post(url, contentType, UTF8Utils.encode(data), protocol, timeout);

		if (httpResponse == null) {
			return null;
		}

		return httpResponse.getResponse();
	}

	public static HttpResponse post(String url, String contentType, byte[] data, String protocol, int timeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		HttpsURLConnection httpsURLConnection = httpsURLConnection(url, "POST", contentType, data, protocol, timeout);

		try (OutputStream outputStream = httpsURLConnection.getOutputStream()) {
			outputStream.write(data);
		} catch (IOException e) {
			throw e;
		}

		return getHttpResponse(httpsURLConnection);
	}

	private static HttpsURLConnection httpsURLConnection(String url, String method, String contentType, String protocol, int timeout) throws KeyManagementException, NoSuchAlgorithmException, IOException {
		return httpsURLConnection(url, method, contentType, null, protocol, timeout);
	}

	private static HttpsURLConnection httpsURLConnection(String url, String method, String contentType, byte[] data, String protocol, int timeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		URL urlObj = new URL(url);
		SSLSocketFactory sslSocketFactory = sslSocketFactory(protocol);
		return httpsURLConnection(urlObj, method, contentType, data, sslSocketFactory, timeout);
	}

	private static HttpsURLConnection httpsURLConnection(URL url, String method, String contentType, byte[] data, SSLSocketFactory sslSocketFactory, int timeout) throws IOException {
		HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
		httpsURLConnection.setDoOutput(true);
		httpsURLConnection.setUseCaches(false);
		httpsURLConnection.setRequestProperty("charset", "utf-8");
		httpsURLConnection.setSSLSocketFactory(sslSocketFactory);

		if (StringHelper.isNullOrEmpty(method)) {
			method = "GET";
		}

		httpsURLConnection.setRequestMethod(method);

		if (!StringHelper.isNullOrEmpty(contentType)) {
			httpsURLConnection.setRequestProperty("content-Type", contentType);
		}

		if (method.equals("POST") && data != null) {
			httpsURLConnection.setRequestProperty("Content-length", String.valueOf(data.length));
		}

		if (timeout > 0) {
			httpsURLConnection.setConnectTimeout(timeout);
			httpsURLConnection.setReadTimeout(timeout);
		}

		httpsURLConnection.setHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
		});

		return httpsURLConnection;
	}

	private static SSLSocketFactory sslSocketFactory(String protocol) throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sslContext = SSLContext.getInstance(protocol);
		sslContext.init(new KeyManager[0], DefaultTrustManager.trustManagers(), null);
		return sslContext.getSocketFactory();
	}
}