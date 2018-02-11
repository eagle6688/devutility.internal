package devutility.internal.models;

import java.util.List;

public class SearchResult<T> {
	private boolean changed;
	private List<T> list;

	public SearchResult() {
		changed = false;
	}

	public SearchResult(List<T> list) {
		this();
		this.list = list;
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setChangedList(List<T> list) {
		setChanged(true);
		setList(list);
	}
}