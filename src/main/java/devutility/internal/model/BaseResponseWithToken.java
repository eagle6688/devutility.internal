package devutility.internal.model;

public class BaseResponseWithToken<T> extends BaseResponse<T> {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}