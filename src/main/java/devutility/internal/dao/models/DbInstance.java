package devutility.internal.dao.models;

public class DbInstance {
	private String host = "";
	private int port = 0;
	private String loginName = "";
	private String password = "";
	private String database = "";
	private int timeout = 3000;
	private String url = "";

	// region Constructor

	public DbInstance() {

	}

	public DbInstance(String host) {
		this();
		this.host = host;
	}

	public DbInstance(String host, int port) {
		this(host);
		this.port = port;
	}

	public DbInstance(String host, int port, String database) {
		this(host, port);
		this.database = database;
	}

	public DbInstance(String host, int port, String database, String loginName) {
		this(host, port, database);
		this.loginName = loginName;
	}

	public DbInstance(String host, int port, String database, String loginName, String password) {
		this(host, port, database, loginName);
		this.password = password;
	}

	// endregion

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}