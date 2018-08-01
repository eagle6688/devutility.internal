package devutility.internal.models;

public class DbInstance {
	private String uri = "";
	private String host = "";
	private int port = 0;
	private String loginname = "";
	private String password = "";
	private String database = "";
	private int timeout = 3000;

	public DbInstance() {

	}

	public DbInstance(String host) {
		this(host, 0, null, null, null);
	}

	public DbInstance(String host, int port) {
		this(host, port, null, null, null);
	}

	public DbInstance(String host, int port, String database) {
		this(host, port, database, null, null);
	}

	public DbInstance(String host, int port, String database, String loginName) {
		this(host, port, database, loginName, null);
	}

	public DbInstance(String host, int port, String database, String loginname, String password) {
		this.host = host;
		this.port = port;
		this.database = database;
		this.loginname = loginname;
		this.password = password;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getLoginName() {
		return loginname;
	}

	public void setLoginName(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
}