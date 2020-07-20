package devutility.internal.model;

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