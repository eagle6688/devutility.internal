package devutility.internal.basic.lang;

public class BytesTest {
	public static void main(String[] args) throws Exception {
		String str1 = "asd!";
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("length of string is: ");
		stringBuffer.append(str1.length());
		System.out.println(stringBuffer.toString());

		stringBuffer.setLength(0);
		stringBuffer.append("length of string bytes is: ");
		stringBuffer.append(str1.getBytes().length);
		System.out.println(stringBuffer.toString());

		String str2 = "ÄãºÃ£¡";
		stringBuffer.setLength(0);
		stringBuffer.append("length of string is: ");
		stringBuffer.append(str2.length());
		System.out.println(stringBuffer.toString());

		stringBuffer.setLength(0);
		stringBuffer.append("length of string bytes is: ");
		stringBuffer.append(str2.getBytes().length);
		System.out.println(stringBuffer.toString());

		int number = 255;
		byte b = intToByte(number);
		System.out.println(String.format("byte: %d", b));

		int number1 = byteToInt(b);
		System.out.println(String.format("number: %d", number1));

		number = 0;
		b = intToByte(number);
		System.out.println(String.format("byte: %d", b));

		number1 = byteToInt(b);
		System.out.println(String.format("number: %d", number1));
	}

	private static int byteToInt(byte b) {
		return b & 0xFF;
	}

	private static byte intToByte(int number) {
		return (byte) number;
	}
}