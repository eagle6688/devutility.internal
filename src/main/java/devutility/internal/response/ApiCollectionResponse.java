package devutility.internal.response;

import java.util.Collection;

/**
 * 
 * ApiCollectionResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-12-29 14:17:11
 * @param <E> Type for item in collection.
 */
public class ApiCollectionResponse<E> extends ApiResponse<Collection<E>> {
	public ApiCollectionResponse(Throwable throwable) {
		super(throwable);
	}

	public ApiCollectionResponse() {
		super();
	}
}