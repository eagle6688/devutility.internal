package devutility.internal.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import devutility.internal.data.codec.UTF8Utils;
import devutility.internal.io.StreamHelper;
import devutility.internal.lang.StringHelper;

public class HttpsUtils {
	public static String get(String url, String protocol) throws KeyManagementException, NoSuchAlgorithmException, IOException {
		return get(url, protocol, 0);
	}

	public static String get(String url, String protocol, int timeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		return get(url, null, protocol, timeout);
	}

	public static String get(String url, String contentType, String protocol, int timeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		byte[] bytes = null;
		HttpsURLConnection httpsURLConnection = httpsURLConnection(url, "GET", contentType, protocol, timeout);

		try (InputStream inputStream = httpsURLConnection.getInputStream()) {
			bytes = StreamHelper.read(inputStream);
		} catch (IOException e) {
			throw e;
		}

		return UTF8Utils.decode(bytes);
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
		httpsURLConnection.setUseCaches(false);
		httpsURLConnection.setRequestProperty("charset", "utf-8");

		if (StringHelper.isNullOrEmpty(method)) {
			method = "GET";
		}

		httpsURLConnection.setRequestMethod(method);

		if (!StringHelper.isNullOrEmpty(contentType)) {
			httpsURLConnection.setRequestProperty("content-Type", contentType);
		}

		if (method.equals("POST") && data != null) {
			httpsURLConnection.setDoOutput(true);
			httpsURLConnection.setRequestProperty("Content-length", String.valueOf(data.length));
		}

		if (timeout > 0) {
			httpsURLConnection.setConnectTimeout(timeout);
			httpsURLConnection.setReadTimeout(timeout);
		}

		return httpsURLConnection;
	}

	private static SSLSocketFactory sslSocketFactory(String protocol) throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sslContext = SSLContext.getInstance(protocol);
		sslContext.init(new KeyManager[0], DefaultTrustManager.trustManagers(), new java.security.SecureRandom());
		return sslContext.getSocketFactory();
	}
}