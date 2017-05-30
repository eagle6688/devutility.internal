package devutility.internal.test.io;

public class TestNewLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = System.getProperty("line.separator");
		System.out.println("\\");
		System.out.println(str.replace('\\', '-'));
		System.out.println("\\");
	}
}