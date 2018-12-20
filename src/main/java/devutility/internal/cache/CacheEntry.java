package devutility.internal.cache;

public class CacheEntry {
	private String key;
	private Object value;
	private int expiredTimeSeconds;
	private long createTime;
	private long expiredTimeMillis;

	public CacheEntry() {
		createTime = System.currentTimeMillis();
	}

	public CacheEntry(String key, Object value, int expiredTimeSeconds) {
		this();
		this.key = key;
		this.value = value;
		this.expiredTimeSeconds = expiredTimeSeconds;
		this.expiredTimeMillis = createTime + expiredTimeSeconds * 1000;
	}

	public CacheEntry(String key, Object value) {
		this(key, value, 0);
	}

	/**
	 * Whether current cache object is expired or not?
	 * @return boolean
	 */
	public boolean expired() {
		if (expiredTimeSeconds == 0) {
			return false;
		}

		return System.currentTimeMillis() > this.expiredTimeMillis;
	}

	/**
	 * Whether current cache object is latest version or not?
	 * @param timestamp Timestamp for the latest cache data.
	 * @return boolean
	 */
	public boolean latestVersion(long timestamp) {
		return this.createTime >= timestamp;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public int getExpiredTimeSeconds() {
		return expiredTimeSeconds;
	}

	public void setExpiredTimeSeconds(int expiredTimeSeconds) {
		this.expiredTimeSeconds = expiredTimeSeconds;
	}

	public long getCreateTime() {
		return createTime;
	}
}