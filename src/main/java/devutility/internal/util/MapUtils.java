package devutility.internal.util;

import java.util.Map;

/**
 * 
 * MapUtils
 * 
 * @author: Aldwin Su
 * @creation: 2021-03-10 10:28:35
 */
public class MapUtils {
	/**
	 * Whether map null or empty?
	 * @param map Map object.
	 * @return boolean
	 */
	public static boolean isNullOrEmpty(Map<?, ?> map) {
		return map == null || map.size() == 0;
	}

	/**
	 * Whether map not empty?
	 * @param map Map object.
	 * @return boolean
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return map != null && map.size() > 0;
	}
}