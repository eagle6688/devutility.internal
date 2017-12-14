package devutility.internal.util;

import java.util.UUID;

public class UUIDHelper {
	// region get

	public static String get() {
		return UUID.randomUUID().toString();
	}

	// endregion
}