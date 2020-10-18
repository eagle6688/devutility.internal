package devutility.internal.model;

import devutility.internal.annotation.Property;

public class PropertiesModel {
	@Property("test.loginName")
	private String loginName;

	private String password;

	@Property("test.timeout")
	private int timeout;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
}