package devutility.internal.response;

/**
 * 
 * ApiWrapResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-12-29 14:25:31
 * @param <T> Type for data.
 */
public class ApiWrapResponse<T> extends ApiResponse<T> {
	public ApiWrapResponse(Throwable throwable) {
		super(throwable);
	}

	public ApiWrapResponse() {
		super();
	}
}