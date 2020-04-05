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
	private long creationTime;
	private long expirationMillis;
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
		this.creationTime = System.currentTimeMillis();
		this.setExpirationMillis(expirationMillis);
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
		this(null);
	}

	/**
	 * Verification for parameters.
	 */
	private void verification() {
		if (value == null) {
			throw new IllegalArgumentException("value can't be null!");
		}

		if (Collection.class.isAssignableFrom(this.value.getClass())) {
			Collection<?> collection = Collection.class.cast(this.value);

			if (CollectionUtils.isNullOrEmpty(collection)) {
				throw new IllegalArgumentException("value can't be empty!");
			}
		}
	}

	/**
	 * Check whether current cache object is expired or not?
	 * @return boolean
	 */
	public boolean isExpired() {
		if (this.expirationMillis <= 0) {
			return false;
		}

		return System.currentTimeMillis() >= this.expirationMillis;
	}

	/**
	 * Check whether current cache object is latest version or not?
	 * @param timestamp Timestamp for the latest cache data.
	 * @return boolean
	 */
	public boolean isLatest(long timestamp) {
		return this.creationTime >= timestamp;
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

	public void setValue(T value) {
		this.value = value;
	}

	public long getCreationTime() {
		return creationTime;
	}

	public long getExpirationMillis() {
		return expirationMillis;
	}

	public void setExpirationMillis(long expirationMillis) {
		this.expirationMillis = expirationMillis;
		this.expirationTime = 0;

		if (expirationMillis > 0) {
			this.expirationTime = this.creationTime + expirationMillis;
		}
	}

	public long getExpirationTime() {
		return expirationTime;
	}
}