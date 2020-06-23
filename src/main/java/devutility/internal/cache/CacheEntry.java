package devutility.internal.cache;

import java.util.Collection;

import devutility.internal.util.CollectionUtils;

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
	private long maxIdleMillis;

	@SuppressWarnings("rawtypes")
	private Comparable version;

	/**
	 * CacheEntry object created time.
	 */
	private long creationTime;
	private long lastUseTime;
	private long expirationTime;

	/**
	 * Constructor
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @param expirationMillis Expiration time in milliseconds, default 0 means no expiration.
	 */
	public CacheEntry(String key, T value, long expirationMillis) {
		this.key = key;
		this.value = value;
		this.setExpirationMillis(expirationMillis);
		this.creationTime = System.currentTimeMillis();
		this.verification();
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
	 * @param value Cache value.
	 * @param expirationMillis Expiration time in milliseconds, default 0 means no expiration.
	 */
	public CacheEntry(T value, long expirationMillis) {
		this(CacheConfig.getKey(value), value, expirationMillis);
	}

	/**
	 * Constructor
	 * @param value Cache value.
	 */
	public CacheEntry(T value) {
		this(value, 0);
	}

	/**
	 * Constructor
	 */
	public CacheEntry() {
	}

	/**
	 * Verification for parameters.
	 */
	private void verification() {
		if (value == null) {
			throw new IllegalArgumentException("Cache value can't be null!");
		}

		if (Collection.class.isAssignableFrom(this.value.getClass())) {
			Collection<?> collection = Collection.class.cast(this.value);

			if (CollectionUtils.isNullOrEmpty(collection)) {
				throw new IllegalArgumentException("Cache value can't be empty!");
			}
		}
	}

	/**
	 * Check whether current cache object is expired or not?
	 * @return boolean
	 */
	public boolean isExpired() {
		if (this.expirationMillis <= 0) {
			return this.isExceedMaxIdleTime();
		}

		return System.currentTimeMillis() >= this.expirationTime;
	}

	/**
	 * Check whether current cache object exceed max idle time or not?
	 * @return boolean
	 */
	public boolean isExceedMaxIdleTime() {
		if (this.maxIdleMillis <= 0) {
			return false;
		}

		return this.getIdleMillis() > this.maxIdleMillis;
	}

	/**
	 * Check whether current cache object is latest version or not?
	 * @param version Version object for comparison.
	 * @return boolean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean isLatest(Comparable version) {
		if (this.version == null) {
			return true;
		}

		return this.version.compareTo(version) >= 0;
	}

	/**
	 * Check whether current cache object is latest version or not?
	 * @param timestamp Timestamp for the latest cache data.
	 * @return boolean
	 */
	public boolean isLatest(long timestamp) {
		return this.creationTime >= timestamp;
	}

	/**
	 * Return idle millis.
	 * @return long
	 */
	public long getIdleMillis() {
		return System.currentTimeMillis() - this.lastUseTime;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		this.lastUseTime = System.currentTimeMillis();
		return value;
	}

	public void setValue(T value) {
		this.value = value;
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

	@SuppressWarnings("rawtypes")
	public Comparable getVersion() {
		return version;
	}

	@SuppressWarnings("rawtypes")
	public void setVersion(Comparable version) {
		this.version = version;
	}

	public long getCreationTime() {
		return creationTime;
	}

	public long getLastUseTime() {
		return lastUseTime;
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