package devutility.internal.net;

import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import devutility.internal.lang.StringHelper;

public class HttpsUtils {
	private static HttpsURLConnection httpsURLConnection(URL url, String method, String contentType, byte[] data, SSLSocketFactory sslSocketFactory) throws IOException {
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

		return null;
	}

	private static SSLSocketFactory sslSocketFactory(String protocol) throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sslContext = SSLContext.getInstance(protocol);
		sslContext.init(new KeyManager[0], DefaultTrustManager.trustManagers(), new java.security.SecureRandom());
		return sslContext.getSocketFactory();
	}
}