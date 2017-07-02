package devutility.internal.io;

import devutility.internal.io.TextHelper;

public class TextHelperTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TextHelper.append("E:\\Downloads\\Test.txt", "asd");
		TextHelper.appendLine("E:\\Downloads\\Test.txt", "newline");
		System.out.println("completely!");
	}
}