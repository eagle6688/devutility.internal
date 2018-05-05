package devutility.internal.lang.models;

import java.util.List;

import devutility.internal.util.CollectionUtils;
import devutility.internal.util.ListHelper;

public class EntityFieldUtils {
	public static List<EntityField> includeEntityFields(List<EntityField> entityFields, List<String> includeFields) {
		if (CollectionUtils.nullOrEmpty(entityFields) || CollectionUtils.nullOrEmpty(includeFields)) {
			return entityFields;
		}

		return ListHelper.list(entityFields, i -> i.getField() != null && includeFields.contains(i.getField().getName()));
	}

	public static List<EntityField> excludeEntityFields(List<EntityField> entityFields, List<String> excludeFields) {
		if (CollectionUtils.nullOrEmpty(entityFields) || CollectionUtils.nullOrEmpty(excludeFields)) {
			return entityFields;
		}

		return ListHelper.list(entityFields, i -> i.getField() != null && !excludeFields.contains(i.getField().getName()));
	}
}