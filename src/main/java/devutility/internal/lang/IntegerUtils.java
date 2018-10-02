package devutility.internal.lang;

public class IntegerUtils {
	public static boolean isNumberic(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isDigit(value.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	public static IntegerConvertResult tryParse(String value) {
		IntegerConvertResult result = new IntegerConvertResult();

		if (!isNumberic(value)) {
			result.setSucceeded(false);
			return result;
		}

		result.setResult(Integer.valueOf(value));
		result.setSucceeded(true);
		return result;
	}
}