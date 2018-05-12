package devutility.internal.net;

import java.io.IOException;
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

public class HttpsUtils extends BaseUtils {
	/**
	 * Get data from Url.
	 * @param url: Request Url.
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @return String
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static String get(String url, String protocol) throws KeyManagementException, NoSuchAlgorithmException, IOException {
		return get(url, protocol, 0);
	}

	/**
	 * Get data from Url.
	 * @param url: Request Url.
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @param timeout: Request timeout.
	 * @return String
	 * @throws IOException
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 */
	public static String get(String url, String protocol, int timeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		HttpResponse httpResponse = get(url, null, protocol, timeout);

		if (httpResponse == null) {
			return null;
		}

		return httpResponse.getResponse();
	}

	/**
	 * Get data from Url.
	 * @param url: Request Url.
	 * @param contentType: Content-Type in http request header.
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @param timeout: Request timeout.
	 * @return HttpResponse
	 * @throws IOException
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 */
	public static HttpResponse get(String url, String contentType, String protocol, int timeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		HttpsURLConnection httpsURLConnection = httpsURLConnection(url, "GET", contentType, null, protocol, timeout);
		return getHttpResponse(httpsURLConnection);
	}

	/**
	 * Get Json data from Url.
	 * @param url: Request Url.
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @return String
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static String getJson(String url, String protocol) throws KeyManagementException, NoSuchAlgorithmException, IOException {
		return getJson(url, protocol, 0);
	}

	/**
	 * Get Json data from Url.
	 * @param url: Request Url.
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @param timeout: Request timeout.
	 * @return String
	 * @throws IOException
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 */
	public static String getJson(String url, String protocol, int timeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		HttpResponse httpResponse = get(url, "application/json", protocol, timeout);

		if (httpResponse == null) {
			return null;
		}

		return httpResponse.getResponse();
	}

	/**
	 * Post data to Url
	 * @param url: Request Url.
	 * @param contentType: Content-Type in http request header.
	 * @param data: Post data.
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @param timeout: Request timeout.
	 * @return String
	 * @throws IOException
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String post(String url, String contentType, String data, String protocol, int timeout) throws KeyManagementException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
		HttpResponse httpResponse = post(url, contentType, UTF8Utils.encode(data), protocol, timeout);

		if (httpResponse == null) {
			return null;
		}

		return httpResponse.getResponse();
	}

	/**
	 * Post
	 * @param url: Request Url.
	 * @param contentType: Content-Type in http request header.
	 * @param data: Post data.
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @param timeout: Request timeout.
	 * @return HttpResponse
	 * @throws IOException
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 */
	public static HttpResponse post(String url, String contentType, byte[] data, String protocol, int timeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		HttpsURLConnection httpsURLConnection = httpsURLConnection(url, "POST", contentType, data, protocol, timeout);
		return request(httpsURLConnection, data);
	}

	/**
	 * Post form data to Url.
	 * @param url: Request Url.
	 * @param data: Form data.
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @return String
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String postForm(String url, String data, String protocol) throws KeyManagementException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
		return postForm(url, data, protocol, 0);
	}

	/**
	 * Post form data to Url.
	 * @param url: Request Url.
	 * @param data: Form data.
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @param timeout: Request timeout.
	 * @return String
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String postForm(String url, String data, String protocol, int timeout) throws KeyManagementException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
		return post(url, "application/x-www-form-urlencoded", data, protocol, timeout);
	}

	/**
	 * Post Json data to Url.
	 * @param url: Request Url.
	 * @param data: Json data.
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @return String
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String postJson(String url, String data, String protocol) throws KeyManagementException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
		return postJson(url, data, protocol, 0);
	}

	/**
	 * Post Json data to Url.
	 * @param url: Request Url.
	 * @param data: Json data.
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @param timeout: Request timeout.
	 * @return String
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String postJson(String url, String data, String protocol, int timeout) throws KeyManagementException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
		return post(url, "application/json", data, protocol, timeout);
	}

	/**
	 * Create an HttpsURLConnection instance.
	 * @param url: Request Url.
	 * @param method: Request method, GET or POST.
	 * @param contentType: Content-Type in http request header.
	 * @param data: Requested data.
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @param timeout: Request timeout.
	 * @return HttpURLConnection
	 * @throws IOException
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 */
	public static HttpsURLConnection httpsURLConnection(String url, String method, String contentType, byte[] data, String protocol, int timeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		SSLSocketFactory sslSocketFactory = sslSocketFactory(protocol);
		return httpsURLConnection(url, method, contentType, data, sslSocketFactory, timeout);
	}

	/**
	 * Create an HttpsURLConnection instance.
	 * @param url: Request Url.
	 * @param method: Request method, GET or POST.
	 * @param contentType: Content-Type in http request header.
	 * @param data: Requested data.
	 * @param sslSocketFactory: SSLSocketFactory object.
	 * @param timeout: Request timeout.
	 * @return HttpURLConnection
	 * @throws IOException
	 */
	public static HttpsURLConnection httpsURLConnection(String url, String method, String contentType, byte[] data, SSLSocketFactory sslSocketFactory, int timeout) throws IOException {
		URL urlObj = new URL(url);
		return httpsURLConnection(urlObj, method, contentType, data, sslSocketFactory, timeout);
	}

	/**
	 * Create an HttpsURLConnection instance.
	 * @param url: Request Url in URL type.
	 * @param method: Request method, GET or POST.
	 * @param contentType: Content-Type in http request header.
	 * @param data: Requested data.
	 * @param sslSocketFactory: SSLSocketFactory object.
	 * @param timeout: Request timeout.
	 * @return HttpURLConnection
	 * @throws IOException
	 */
	public static HttpsURLConnection httpsURLConnection(URL url, String method, String contentType, byte[] data, SSLSocketFactory sslSocketFactory, int timeout) throws IOException {
		HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
		initHttpURLConnection(httpsURLConnection, method, contentType, data, timeout);
		httpsURLConnection.setSSLSocketFactory(sslSocketFactory);

		httpsURLConnection.setHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
		});

		return httpsURLConnection;
	}

	/**
	 * Create an SslSocketFactory instance
	 * @param protocol: Protocol for SSLSocketFactory, SSL or TLS.
	 * @return SSLSocketFactory
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	private static SSLSocketFactory sslSocketFactory(String protocol) throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sslContext = SSLContext.getInstance(protocol);
		sslContext.init(new KeyManager[0], DefaultTrustManager.trustManagers(), null);
		return sslContext.getSocketFactory();
	}
}