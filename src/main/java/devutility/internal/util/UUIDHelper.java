package devutility.internal.util;

import java.util.UUID;

public class UUIDHelper {
	public static String get() {
		return UUID.randomUUID().toString();
	}
}