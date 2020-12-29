package devutility.internal.model;

/**
 * 
 * EasyResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-12-29 11:04:00
 */
public class EasyResponse extends BaseResponse<Object> {
	public EasyResponse(boolean succeeded, String message, Object code, Object data) {
		super(succeeded, message, code, data);
	}

	public EasyResponse(Object data) {
		super(data);
	}

	public EasyResponse(String message) {
		super(message);
	}

	public EasyResponse(Throwable throwable) {
		super(throwable);
	}

	public EasyResponse() {
		super();
	}
}