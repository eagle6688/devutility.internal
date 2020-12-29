package devutility.internal.response;

import java.util.Map;

/**
 * 
 * ApiMapResponse
 * 
 * @author: Aldwin Su
 * @creation: 2020-12-29 14:27:20
 * @param <K> type of key in map.
 * @param <V> type of value in map.
 */
public class ApiMapResponse<K, V> extends ApiResponse<Map<K, V>> {
	public ApiMapResponse(Throwable throwable) {
		super(throwable);
	}

	public ApiMapResponse() {
		super();
	}

	public V get(K key) {
		return super.getData().get(key);
	}

	public V put(K key, V value) {
		return super.getData().put(key, value);
	}
}