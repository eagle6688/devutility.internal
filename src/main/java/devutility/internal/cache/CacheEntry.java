package devutility.internal.cache;

/**
 * 
 * CacheEntry
 * 
 * @author: Aldwin Su
 * @version: 2017-11-22 17:40:28
 */
public class CacheEntry<T> {
	private String key;
	private T value;
	private long expirationMillis;
	private long version;
	private long maxIdleMillis;

	private long creationTime;
	private long lastUsageTime;
	private long expirationTime;

	/**
	 * Constructor
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @param expirationMillis Expiration time in milliseconds, default 0 means no expiration.
	 * @param version Version of CacheEntry object.
	 */
	public CacheEntry(String key, T value, long expirationMillis, long version) {
		this.key = key;
		this.value = value;
		this.creationTime = System.currentTimeMillis();
		this.setExpirationMillis(expirationMillis);
		this.version = version;

		if (this.version == 0) {
			this.version = this.creationTime;
		}
	}

	/**
	 * Constructor
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @param expirationMillis Expiration time in milliseconds, default 0 means no expiration.
	 */
	public CacheEntry(String key, T value, long expirationMillis) {
		this(key, value, expirationMillis, 0);
	}

	/**
	 * Constructor
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 */
	public CacheEntry(String key, T value) {
		this(key, value, 0);
	}

	/**
	 * Constructor
	 */
	public CacheEntry() {
	}

	/**
	 * Check whether current cache object is expired or not?
	 * @return boolean
	 */
	public boolean isExpired() {
		if (this.expirationMillis <= 0) {
			return this.isExceedMaxIdleTime();
		}

		return System.currentTimeMillis() > this.expirationTime;
	}

	/**
	 * Check whether current cache object exceed max idle time or not?
	 * @return boolean
	 */
	public boolean isExceedMaxIdleTime() {
		if (this.maxIdleMillis <= 0 || this.lastUsageTime == 0) {
			return false;
		}

		return this.getIdleMillis() > this.maxIdleMillis;
	}

	/**
	 * Check whether current cache object is latest version or not?
	 * @param version Latest version for comparison.
	 * @return boolean
	 */
	public boolean isLatest(long version) {
		return this.version >= version;
	}

	/**
	 * The cache object is available means it's neither expired nor deprecated.
	 * @param version Latest version for comparison.
	 * @return boolean
	 */
	public boolean isAvailable(long version) {
		return !isExpired() && isLatest(version);
	}

	/**
	 * Return idle time in milliseconds.
	 * @return long
	 */
	public long getIdleMillis() {
		return System.currentTimeMillis() - this.lastUsageTime;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		this.setLastUsageTime(System.currentTimeMillis());
		return value;
	}

	public long getExpirationMillis() {
		return expirationMillis;
	}

	public void setExpirationMillis(long expirationMillis) {
		this.expirationMillis = expirationMillis;
		this.setExpirationTime(expirationMillis);
	}

	public long getMaxIdleMillis() {
		return maxIdleMillis;
	}

	public void setMaxIdleMillis(long maxIdleMillis) {
		this.maxIdleMillis = maxIdleMillis;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public long getCreationTime() {
		return creationTime;
	}

	public long getLastUsageTime() {
		return lastUsageTime;
	}

	private void setLastUsageTime(long lastUsageTime) {
		this.lastUsageTime = lastUsageTime;
	}

	public long getExpirationTime() {
		return expirationTime;
	}

	private void setExpirationTime(long expirationMillis) {
		if (expirationMillis <= 0) {
			this.expirationTime = 0;
			return;
		}

		this.expirationTime = this.creationTime + expirationMillis;
	}
}