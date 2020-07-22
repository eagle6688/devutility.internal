package devutility.internal.model;

/**
 * 
 * OperationResult
 * 
 * @author: Aldwin Su
 * @version: 2017-12-01 18:46:09
 */
public class OperationResult extends BaseResponse<Object> {
	public OperationResult(boolean succeeded, String message, Object data, int code) {
		super(succeeded, message, data, code);
	}

	public OperationResult(Object data) {
		super(data);
	}

	public OperationResult() {
		super();
	}
}