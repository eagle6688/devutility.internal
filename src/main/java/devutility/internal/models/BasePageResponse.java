package devutility.internal.models;

import java.util.List;

public class BasePageResponse<T> extends BaseResponse<List<T>> {
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}