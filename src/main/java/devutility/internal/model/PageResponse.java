package devutility.internal.model;

import java.util.Collection;

/**
 * 
 * PageResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-07-21 16:13:52
 * @param <E> Type for item in collection.
 */
public class PageResponse<E> extends CollectionResponse<E> {
	private long total;
	private int pageIndex;
	private int pageSize;

	public PageResponse(boolean succeeded, String message, Object code, Collection<E> collection) {
		super(succeeded, message, code, collection);
	}

	public PageResponse(int pageIndex, int pageSize, Collection<E> collection) {
		this.setPageIndex(pageIndex);
		this.setPageSize(pageSize);
		super.setData(collection);
	}

	public PageResponse(int pageIndex, int pageSize) {
		this.setPageIndex(pageIndex);
		this.setPageSize(pageSize);
	}

	public PageResponse(Collection<E> collection) {
		super(collection);
	}

	public PageResponse(String message) {
		super(message);
	}

	public PageResponse(Throwable throwable) {
		super(throwable);
	}

	public PageResponse() {
		super();
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