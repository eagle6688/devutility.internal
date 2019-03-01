package devutility.internal.test.models;

/**
 * 
 * Gender
 * 
 * @author: Aldwin Su
 */
public enum Gender {
	/**
	 * Unknow
	 */
	UNKNOW(0),

	/**
	 * Mail
	 */
	MALE(1),

	/**
	 * Femail
	 */
	FEMALE(2);

	private int value;

	private Gender(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static Gender parse(String value) {
		Gender[] array = Gender.values();

		for (int i = 0; i < array.length; i++) {
			if (Integer.valueOf(value) == array[i].value) {
				return array[i];
			}
		}

		return Gender.UNKNOW;
	}

	public static Gender parse(int value) {
		Gender[] array = Gender.values();

		for (int i = 0; i < array.length; i++) {
			if (value == array[i].value) {
				return array[i];
			}
		}

		return Gender.UNKNOW;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}