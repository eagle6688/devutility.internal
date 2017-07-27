package devutility.internal.io;


public class TextHelperTest {
	public static void main(String[] args) throws Exception {
		TextHelper.append("E:\\Downloads\\Test.txt", "asd");
		TextHelper.appendLine("E:\\Downloads\\Test.txt", "newline");
		System.out.println("completely!");
	}
}