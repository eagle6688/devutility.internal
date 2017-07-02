package devutility.internal.io;

public class BytesTest {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
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
	}
}