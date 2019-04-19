package devutility.internal.test.basic.lang;

public class NewLineTest {
	public static void main(String[] args) {
		String str = System.getProperty("line.separator");
		System.out.println("\\");
		System.out.println(str.replace('\\', '-'));
		System.out.println("\\");
	}
}