package devutility.internal.model;

/**
 * 
 * BaseResponse
 * 
 * @author: Aldwin Su
 * @creation: 2018-11-14 19:23:05
 */
public class BaseResponse<T> {
	private boolean succeeded;
	private String message;
	private T data;
	private int code;

	public BaseResponse(boolean succeeded, String message, T data, int code) {
		this.setSucceeded(succeeded);
		this.setMessage(message);
		this.setData(data);
		this.setCode(code);
	}

	public BaseResponse(T data) {
		this(true, null, data, 0);
	}

	public BaseResponse() {
		this.setSucceeded(true);
	}

	public void setErrorMessage(String message) {
		this.setSucceeded(false);
		this.setMessage(message);
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}