package devutility.internal.model;

import java.util.List;

/**
 * 
 * ListResponse
 * 
 * @author: Aldwin Su
 * @creation: 2018-11-14 19:23:05
 */
public class ListResponse<E> extends BaseResponse<List<E>> {
	public ListResponse() {
		super();
	}

	public ListResponse(List<E> list) {
		super(list);
	}
}