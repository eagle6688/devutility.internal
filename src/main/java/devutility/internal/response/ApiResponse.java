package devutility.internal.response;

import devutility.internal.com.CommonResultCode;

/**
 * 
 * ApiResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-12-29 13:58:42
 * @param <T> Type for data.
 */
public class ApiResponse<T> extends BaseResponse<T> {
	private int status = 200;
	private String body;

	public ApiResponse(Throwable throwable) {
		super.setErrorMessage(throwable.getMessage());

		if (super.getCode() == null) {
			super.setCode(CommonResultCode.SYSTEMERROR.getCode());
		}
	}

	public ApiResponse() {
		super();
	}

	public boolean isRequestFailed() {
		return this.getStatus() >= 400 || super.hasException();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}