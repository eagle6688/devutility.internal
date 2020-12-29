package devutility.internal.response;

import java.util.Map;

/**
 * 
 * MapResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-11-21 17:28:44
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class MapResponse<K, V> extends BaseResponse<Map<K, V>> {
	public MapResponse(boolean succeeded, String message, Object code, Map<K, V> map) {
		super(succeeded, message, code, map);
	}

	public MapResponse(Map<K, V> map) {
		super(map);
	}

	public MapResponse(String message) {
		super(message);
	}

	public MapResponse(Throwable throwable) {
		super(throwable);
	}

	public MapResponse() {
		super();
	}

	public V get(K key) {
		return super.getData().get(key);
	}

	public V put(K key, V value) {
		return super.getData().put(key, value);
	}
}