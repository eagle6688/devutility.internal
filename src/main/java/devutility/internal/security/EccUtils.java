package devutility.internal.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import devutility.internal.data.codec.Base64Utils;

public class EccUtils {
	/**
	 * Charset name
	 */
	private final static String CHARSET = "UTF-8";

	/**
	 * algorithm the name of the requested key algorithm.
	 */
	private final static String ALGORITHM = "EC";

	/**
	 * provider the name of the provider.
	 */
	private final static String KEYPROVIDER = "SunEC";

	/**
	 * the standard name of the to-be-generated EC
	 */
	private final static String STANDARDNAMEFOREC = "secp384r1";

	/**
	 * Get public key string for ECC encryption.
	 * @param publicKey PublicKey object.
	 * @return String
	 * @throws GeneralSecurityException
	 * @throws UnsupportedEncodingException
	 */
	public static String getPublicKey(PublicKey publicKey) throws GeneralSecurityException, UnsupportedEncodingException {
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM, KEYPROVIDER);
		X509EncodedKeySpec encodedKeySpec = keyFactory.getKeySpec(publicKey, X509EncodedKeySpec.class);
		return Base64Utils.encodeToString(encodedKeySpec.getEncoded());
	}

	/**
	 * Get public key string for ECC encryption.
	 * @param key PublicKey object.
	 * @return String
	 * @throws UnsupportedEncodingException
	 * @throws GeneralSecurityException
	 */
	public static String getPublicKey(String key) throws UnsupportedEncodingException, GeneralSecurityException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM, KEYPROVIDER);
		ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec(STANDARDNAMEFOREC);
		keyPairGenerator.initialize(ecGenParameterSpec);
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		return getPublicKey(keyPair.getPublic());
	}

	public static byte[] decrypt(byte[] data, String key) throws Exception {
		byte[] keyBytes = key.getBytes(Charset.forName(CHARSET));
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		return null;
	}
}