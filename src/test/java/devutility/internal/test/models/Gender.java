package devutility.internal.test.models;

public enum Gender {
	UNKNOW(0), MALE(1), FEMALE(2);

	private int value;

	private Gender(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
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
}