package devutility.internal.test.models;

import devutility.internal.annotations.PropertiesKey;

public class PropertiesModel {
	@PropertiesKey("test.loginName")
	private String loginName;

	@PropertiesKey("test.password")
	private String password;

	@PropertiesKey("test.timeout")
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