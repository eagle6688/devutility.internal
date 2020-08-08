package devutility.internal.lang;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import devutility.internal.model.ObjectField;
import devutility.internal.util.CollectionUtils;

/**
 * 
 * EntityFieldUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-12-09 23:33:45
 */
public class EntityFieldUtils {
	/**
	 * Filtering EntityField objects with provided includeFields.
	 * @param entityFields EntityField objects.
	 * @param includeFields Fields need include.
	 * @return List<EntityField>
	 */
	public static List<ObjectField> includeEntityFields(List<ObjectField> entityFields, Collection<String> includeFields) {
		if (CollectionUtils.isNullOrEmpty(includeFields)) {
			return entityFields;
		}

		return CollectionUtils.list(entityFields, i -> i.getField() != null && includeFields.contains(i.getField().getName()));
	}

	/**
	 * Filtering EntityField objects with provided includeFields.
	 * @param entityFields
	 * @param includeFields
	 * @return List<EntityField>
	 */
	public static List<ObjectField> includeEntityFields(List<ObjectField> entityFields, String[] includeFields) {
		if (includeFields == null || includeFields.length == 0) {
			return entityFields;
		}

		return includeEntityFields(entityFields, new HashSet<String>(Arrays.asList(includeFields)));
	}

	/**
	 * Filtering EntityField objects with provided excludeFields.
	 * @param entityFields EntityField objects.
	 * @param excludeFields Fields need exclude.
	 * @return List<EntityField>
	 */
	public static List<ObjectField> excludeEntityFields(List<ObjectField> entityFields, Collection<String> excludeFields) {
		if (CollectionUtils.isNullOrEmpty(excludeFields)) {
			return entityFields;
		}

		return CollectionUtils.list(entityFields, i -> i.getField() != null && !excludeFields.contains(i.getField().getName()));
	}

	/**
	 * Filtering EntityField objects with provided excludeFields.
	 * @param entityFields EntityField objects.
	 * @param excludeFields Fields need exclude.
	 * @return List<EntityField>
	 */
	public static List<ObjectField> excludeEntityFields(List<ObjectField> entityFields, String[] excludeFields) {
		if (excludeFields == null || excludeFields.length == 0) {
			return entityFields;
		}

		return excludeEntityFields(entityFields, new HashSet<String>(Arrays.asList(excludeFields)));
	}
}