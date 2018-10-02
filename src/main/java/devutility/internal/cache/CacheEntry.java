package devutility.internal.cache;

public class CacheEntry {
	private String key;
	private Object value;
	private int expireSeconds;
	private long createTime;

	public CacheEntry() {
		createTime = System.currentTimeMillis();
	}

	public CacheEntry(String key, Object value, int expireSeconds) {
		this();
		this.key = key;
		this.value = value;
		this.expireSeconds = expireSeconds;
	}

	public CacheEntry(String key, Object value) {
		this(key, value, 0);
	}

	public boolean expired() {
		if (expireSeconds == 0) {
			return false;
		}

		return System.currentTimeMillis() <= (expireSeconds * 1000 + createTime);
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

	public int getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(int expireSecond) {
		this.expireSeconds = expireSecond;
	}

	public long getCreateTime() {
		return createTime;
	}
}