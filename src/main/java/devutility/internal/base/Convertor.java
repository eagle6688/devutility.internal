package devutility.internal.base;

public class Convertor {
	public static int StringToInt(String value) {
		try {
			int result = Integer.parseInt(value);
			return result;
		} catch (Exception e) {
			return 0;
		}
	}
}