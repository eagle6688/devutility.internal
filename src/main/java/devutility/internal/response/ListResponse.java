package devutility.internal.response;

import java.util.List;

/**
 * 
 * ListResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-12-29 14:31:12
 * @param <E> Type for item in List.
 */
public class ListResponse<E> extends BaseResponse<List<E>> {
	public ListResponse(boolean succeeded, String message, Object code, List<E> list) {
		super(succeeded, message, code, list);
	}

	public ListResponse(List<E> list) {
		super(list);
	}

	public ListResponse(String message) {
		super(message);
	}

	public ListResponse(Throwable throwable) {
		super(throwable);
	}

	public ListResponse() {
		super();
	}
}