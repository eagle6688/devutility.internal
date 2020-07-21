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
	private long total;
	private int pageIndex;
	private int pageSize;

	public PageResponse() {
		super();
	}

	public PageResponse(List<E> list) {
		super(list);
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}