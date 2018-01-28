package devutility.internal.dao.models;

/**
 * @Description: RedisInstance
 * @author: Aldwin
 */
public class RedisInstance extends DbInstance {
	private int dbIndex = 0;
	private int maxConnections = 1000;

	public int getDBIndex() {
		return dbIndex;
	}

	public void setDBIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

	public int getMaxConnections() {
		return maxConnections;
	}

	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}
}