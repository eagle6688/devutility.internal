package devutility.internal.security;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/**
 * 
 * DUSocketFactory
 * 
 * @author: Aldwin Su
 * @version: 2020-04-22 14:57:08
 */
public class DUSocketFactory extends SocketFactory {
	/**
	 * Secure protocal such as TLS or SSL.
	 */
	private String secureProtocol;

	/**
	 * SSLContext object.
	 */
	private SSLContext sslContext;

	/**
	 * Custom SocketFactory object.
	 */
	private SocketFactory socketFactory;

	/**
	 * Constructor
	 * @param secureProtocol
	 */
	public DUSocketFactory(String secureProtocol) {
		this.secureProtocol = secureProtocol;

		try {
			this.sslContext = SSLContext.getInstance(this.secureProtocol);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		try {
			this.sslContext.init(null, new TrustManager[] { TrustManagerHolder.DU_TRUST_MANAGER }, new SecureRandom());
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}

		this.socketFactory = this.sslContext.getSocketFactory();
	}

	/**
	 * Constructor
	 */
	public DUSocketFactory() {
		this("TLS");
	}

	@Override
	public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
		return this.socketFactory.createSocket(host, port);
	}

	@Override
	public Socket createSocket(InetAddress inetAddress, int port) throws IOException {
		return this.socketFactory.createSocket(inetAddress, port);
	}

	@Override
	public Socket createSocket(String host, int port, InetAddress inetAddress, int localPort) throws IOException, UnknownHostException {
		return this.socketFactory.createSocket(host, port, inetAddress, localPort);
	}

	@Override
	public Socket createSocket(InetAddress inetAddress, int port, InetAddress localAddress, int localPort) throws IOException {
		return this.socketFactory.createSocket(inetAddress, port, localAddress, localPort);
	}

	public String getSecureProtocol() {
		return secureProtocol;
	}
}