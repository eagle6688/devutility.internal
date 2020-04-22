package devutility.internal.security;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * 
 * TrustManagerHolder
 * 
 * @author: Aldwin Su
 * @version: 2020-04-22 14:47:49
 */
public class TrustManagerHolder {
	/**
	 * X509TrustManager instance, not safe.
	 */
	public final static TrustManager DU_TRUST_MANAGER = new X509TrustManager() {
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	};
}