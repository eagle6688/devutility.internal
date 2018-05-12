package devutility.internal.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

import devutility.internal.data.codec.UTF8Utils;
import devutility.internal.io.StreamHelper;
import devutility.internal.lang.StringHelper;

public abstract class BaseUtils {
	protected static void initHttpURLConnection(HttpURLConnection httpURLConnection, String method, String contentType, byte[] data, int timeout) throws ProtocolException {
		httpURLConnection.setDoOutput(true);
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
			httpURLConnection.setRequestProperty("Content-length", String.valueOf(data.length));
		}

		if (timeout > 0) {
			httpURLConnection.setConnectTimeout(timeout);
			httpURLConnection.setReadTimeout(timeout);
		}
	}

	protected static HttpResponse getHttpResponse(HttpURLConnection httpURLConnection) throws IOException {
		if (httpURLConnection == null) {
			return null;
		}

		HttpResponse httpResponse = new HttpResponse();
		httpResponse.setCode(httpURLConnection.getResponseCode());
		httpResponse.setMessage(httpURLConnection.getResponseMessage());

		byte[] bytes = null;
		InputStream inputStream = null;

		try {
			if (httpResponse.getCode() >= 400) {
				inputStream = httpURLConnection.getErrorStream();
			} else {
				inputStream = httpURLConnection.getInputStream();
			}

			bytes = StreamHelper.read(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
		}

		if (bytes != null) {
			httpResponse.setBytes(bytes);
			httpResponse.setResponse(UTF8Utils.decode(bytes));
		}

		return httpResponse;
	}

	public static HttpResponse request(HttpURLConnection httpURLConnection, byte[] data) throws IOException {
		if (httpURLConnection == null) {
			return null;
		}

		sendData(httpURLConnection, data);
		return getHttpResponse(httpURLConnection);
	}

	private static void sendData(HttpURLConnection httpURLConnection, byte[] data) throws IOException {
		if (httpURLConnection == null || data == null) {
			return;
		}

		try (OutputStream outputStream = httpURLConnection.getOutputStream()) {
			outputStream.write(data);
		} catch (IOException e) {
			throw e;
		}
	}
}