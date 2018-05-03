package devutility.internal.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import devutility.internal.data.codec.UTF8Utils;
import devutility.internal.io.StreamHelper;

public abstract class BaseUtils {
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
}