package devutility.internal.cache;

/**
 * 
 * CacheEntry
 * 
 * @author: Aldwin Su
 * @creation: 2017-11-22 17:40:28
 */
public class CacheEntry<T> {
	/**
	 * Cache key.
	 */
	private String key;

	/**
	 * Cache value.
	 */
	private T value;

	/**
	 * Optional parameter, cache expiration time in millisecond, default value 0 means never expire. This parameter with
	 * higher priority than maxIdleMillis.
	 */
	private long expiration;

	/**
	 * Optional parameter, default value is creation time.
	 */
	private long version;

	/**
	 * Optional parameter, default value 0 allows endless idle. This parameter with lower priority than expiration.
	 */
	private long maxIdle;

	/**
	 * Internal parameter, automatical value.
	 */
	private long creation;

	/**
	 * Internal parameter, last usage time for current CacheEntry object.
	 */
	private long lastUsageTime;

	/**
	 * Constructor
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @param expiration Expiration time in millisecond, default 0 means no expiration.
	 * @param version Version of CacheEntry object.
	 */
	public CacheEntry(String key, T value, long expiration, long version) {
		this.setKey(key);
		this.setValue(value);
		this.setExpiration(expiration);
		this.setVersion(version);
		this.setCreation(System.currentTimeMillis());

		if (this.getVersion() == 0) {
			this.setVersion(this.getCreation());
		}

		this.setLastUsageTime(this.getCreation());
	}

	/**
	 * Constructor
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @param expiration Expiration time in millisecond, default 0 means no expiration.
	 */
	public CacheEntry(String key, T value, long expiration) {
		this(key, value, expiration, 0);
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
	 * Whether current cache object is expired or not?
	 * @return boolean
	 */
	public boolean isExpired() {
		if (this.getExpiration() == 0) {
			return this.isExceedMaxIdleTime();
		}

		long expirationTime = this.getCreation() + this.getExpiration();
		return System.currentTimeMillis() > expirationTime;
	}

	/**
	 * Whether idle time of current cache object exceed max idle time or not?
	 * @return boolean
	 */
	public boolean isExceedMaxIdleTime() {
		if (this.getMaxIdle() == 0 || this.getLastUsageTime() == this.getCreation()) {
			return false;
		}

		return this.getIdleTime() > this.getMaxIdle();
	}

	/**
	 * Return idle time in millisecond.
	 * @return long
	 */
	public long getIdleTime() {
		return System.currentTimeMillis() - this.getLastUsageTime();
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

	public T setValue(T value, long version) {
		T oldValue = this.getValue();
		this.setValue(value);
		this.setVersion(version);
		return oldValue;
	}

	public T getValue() {
		this.setLastUsageTime(System.currentTimeMillis());
		return value;
	}

	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}

	public long getExpiration() {
		return expiration;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public long getVersion() {
		return version;
	}

	public void setMaxIdle(long maxIdle) {
		this.maxIdle = maxIdle;
	}

	public long getMaxIdle() {
		return maxIdle;
	}

	private void setCreation(long creation) {
		this.creation = creation;
	}

	public long getCreation() {
		return creation;
	}

	private void setLastUsageTime(long lastUsageTime) {
		this.lastUsageTime = lastUsageTime;
	}

	public long getLastUsageTime() {
		return lastUsageTime;
	}
}