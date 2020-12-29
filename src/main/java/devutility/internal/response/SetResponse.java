package devutility.internal.response;

import java.util.Set;

/**
 * 
 * SetResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-12-29 14:35:19
 * @param <E> Type for item in Set.
 */
public class SetResponse<E> extends BaseResponse<Set<E>> {
	public SetResponse(boolean succeeded, String message, Object code, Set<E> set) {
		super(succeeded, message, code, set);
	}

	public SetResponse(Set<E> set) {
		super(set);
	}

	public SetResponse(String message) {
		super(message);
	}

	public SetResponse(Throwable throwable) {
		super(throwable);
	}

	public SetResponse() {
		super();
	}
}