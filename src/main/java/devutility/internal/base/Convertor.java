package devutility.internal.base;

public class Convertor {
	public static int stringToInt(String value) {
		try {
			int result = Integer.parseInt(value);
			return result;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static int byteToInt(byte b) {
		return b & 0xFF;
	}
	
	public static byte intToByte(int number) {
		return (byte) number;
	}
}