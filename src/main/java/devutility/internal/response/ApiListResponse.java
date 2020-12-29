package devutility.internal.response;

import java.util.List;

/**
 * 
 * ApiListResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-12-29 14:19:37
 * @param <E> Type for item in collection.
 */
public class ApiListResponse<E> extends BaseResponse<List<E>> {
	public ApiListResponse(Throwable throwable) {
		super(throwable);
	}

	public ApiListResponse() {
		super();
	}
}