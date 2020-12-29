package devutility.internal.response;

import devutility.internal.com.CommonResultCode;

/**
 * 
 * BaseResponse
 * 
 * @author: Aldwin Su
 * @creation: 2018-11-14 19:23:05
 * @param <T> Type for data.
 */
public class BaseResponse<T> {
	private boolean succeeded = true;
	private String message;
	private Object code;
	private T data;

	public BaseResponse(boolean succeeded, String message, Object code, T data) {
		this.setSucceeded(succeeded);
		this.setMessage(message);
		this.setCode(code);
		this.setData(data);
	}

	public BaseResponse(T data) {
		this.setData(data);
	}

	public BaseResponse(String message) {
		this.setMessage(message);
	}

	public BaseResponse(Throwable throwable) {
		this.setCode(CommonResultCode.SYSTEMERROR.getCode());
		this.setError(throwable);
	}

	public BaseResponse() {
	}

	public void set(String code, String messageFormat, Object... args) {
		this.setMessage(String.format(messageFormat, args));
		this.setCode(code);
	}

	public void set(String code, String message) {
		this.setMessage(message);
		this.setCode(code);
	}

	public void setError(String code, String messageFormat, Object... args) {
		this.set(code, messageFormat, args);
		this.setSucceeded(false);
	}

	public void setError(String code, String message) {
		this.set(code, message);
		this.setSucceeded(false);
	}

	public void setError(Throwable throwable) {
		this.setErrorMessage(throwable.toString());
	}

	public void setErrorMessage(String message) {
		this.setSucceeded(false);
		this.setMessage(message);
	}

	public void setExcludeData(BaseResponse<?> response) {
		this.setSucceeded(response.isSucceeded());
		this.setMessage(response.getMessage());
		this.setCode(response.getCode());
	}

	public void clearExcludeData() {
		this.setSucceeded(true);
		this.setMessage(null);
		this.setCode(null);
	}

	public boolean hasException() {
		if (this.isSucceeded()) {
			return false;
		}

		return CommonResultCode.SYSTEMERROR.isCode(this.getCodeAsString());
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	public void setSucceeded(boolean succeeded) {
		this.succeeded = succeeded;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getCode() {
		return code;
	}

	public int getCodeAsInt() {
		if (this.code == null) {
			return 0;
		}

		return Integer.valueOf(this.code.toString());
	}

	public String getCodeAsString() {
		if (this.code == null) {
			return null;
		}

		return this.code.toString();
	}

	public void setCode(Object code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}