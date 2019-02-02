package devutility.internal.models;

public class BaseListResponseWithToken<E> extends BaseListResponse<E> {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}