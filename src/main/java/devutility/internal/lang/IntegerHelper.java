package devutility.internal.lang;

public class IntegerHelper {
	// region Is numeric

	public static boolean isNumberic(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isDigit(value.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	// endregion

	// region Try parse to int

	public static IntegerConvertResult TryParse(String value) {
		IntegerConvertResult result = new IntegerConvertResult();

		if (!isNumberic(value)) {
			result.setSucceeded(false);
			return result;
		}

		result.setResult(Integer.valueOf(value));
		result.setSucceeded(true);
		return result;
	}

	// endregion
}

class IntegerConvertResult {
	private boolean succeeded = false;
	private int result = 0;

	public boolean getSucceeded() {
		return succeeded;
	}

	public void setSucceeded(boolean succeeded) {
		this.succeeded = succeeded;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}