package devutility.internal.test.service.enums;

public enum MyEnum {
	UNKNOW(10), ASD(11), QWE(12);

	public int value;

	MyEnum(int value) {
		this.value = value;
	}

	public static MyEnum parse(int value) {
		MyEnum[] array = MyEnum.values();

		for (int i = 0; i < array.length; i++) {
			if (value == array[i].value) {
				return array[i];
			}
		}

		return MyEnum.UNKNOW;
	}

	@Override
	public String toString() {
		return this.name() + String.valueOf(value);
	}
}