package devutility.internal.model;

import java.util.List;

/**
 * 
 * PageResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-07-21 16:13:52
 */
public class PageResponse<E> extends ListResponse<E> {
	private int count;

	public PageResponse() {
		super();
	}

	public PageResponse(List<E> list) {
		super(list);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}