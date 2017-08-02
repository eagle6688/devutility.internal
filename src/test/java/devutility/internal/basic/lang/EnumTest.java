package devutility.internal.basic.lang;

public class EnumTest {
	public enum Size {
		SMALL, MEDIUM, LARGE, EXTRA_LARGE
	}

	// enum with constructor
	public enum Size2 {
		SMALL("S"), MEDIUM("M"), LARGE("L");

		private String abbreviation;

		private Size2(String abbreviation) {
			this.abbreviation = abbreviation;
		}

		public String getAbbreviation() {
			return abbreviation;
		}
	}

	public enum ResultCode {
		Error(-1), OK(0), Warning(1), Unknow(100);

		private int value;

		private ResultCode(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static ResultCode toResultCode(int value) {
			ResultCode[] array = ResultCode.values();

			for (int i = 0; i < array.length; i++) {
				if (value == array[i].getValue()) {
					return array[i];
				}
			}

			return ResultCode.Unknow;
		}
	}

	public static void main(String[] args) {
		// No need equal for compare
		Size s1 = Size.LARGE;
		Size s2 = Size.LARGE;

		if (s1 == s2) {
			System.out.println("equals!");
		}

		// toString
		System.out.println(s1.toString());

		// valueOf
		Size s3 = Size.valueOf("LARGE");
		System.out.println(s3);

		// values
		Size[] sizes = Size.values();

		for (Size size : sizes) {
			System.out.println(size);
		}

		// orinal
		System.out.println(Size.LARGE.ordinal());

		Size2 s4 = Size2.MEDIUM;
		System.out.println(s4);
		System.out.println(s4.toString());
		System.out.println(s4.getAbbreviation());

		Size2 s5 = Size2.valueOf(s4.toString());
		System.out.println(s5);

		// Cannot convert s4.getAbbreviation() to Size2
		// Size2 s6 = Size2.valueOf(s4.getAbbreviation());
		// System.out.println(s6);

		ResultCode rc1 = ResultCode.OK;
		System.out.println(rc1);
		System.out.println(rc1.toString());
		System.out.println(rc1.getValue());
		
		ResultCode rc2=ResultCode.toResultCode(rc1.getValue());
		System.out.println(rc2);
	}
}