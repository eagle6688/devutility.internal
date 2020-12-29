package devutility.internal.response;

import java.util.Collection;

/**
 * 
 * CollectionResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-12-29 11:16:18
 * @param <E> Type for item in collection.
 */
public class CollectionResponse<E> extends BaseResponse<Collection<E>> {
	public CollectionResponse(boolean succeeded, String message, Object code, Collection<E> collection) {
		super(succeeded, message, code, collection);
	}

	public CollectionResponse(Collection<E> collection) {
		super(collection);
	}

	public CollectionResponse(String message) {
		super(message);
	}

	public CollectionResponse(Throwable throwable) {
		super(throwable);
	}

	public CollectionResponse() {
		super();
	}
}