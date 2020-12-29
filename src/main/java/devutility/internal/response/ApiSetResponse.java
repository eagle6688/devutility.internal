package devutility.internal.response;

import java.util.Set;

/**
 * 
 * ApiSetResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-12-29 14:21:38
 * @param <E> Type for item in collection.
 */
public class ApiSetResponse<E> extends BaseResponse<Set<E>> {
	public ApiSetResponse(Throwable throwable) {
		super(throwable);
	}

	public ApiSetResponse() {
		super();
	}
}