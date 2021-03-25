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
		super(throwable, CommonResultCode.REQUESTREMOTESERVICEFAILED.getCode());
	}

	public ApiResponse() {
		super();
	}

	public boolean isFailedRequest() {
		return super.hasException() || (CommonResultCode.REQUESTREMOTESERVICEFAILED.isCode(super.getCode().toString()) && super.isFailed());
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