package devutility.internal.test.service.base.convertor;

import devutility.internal.base.Convertor;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class IntAndByteService extends BaseTest {
	public static void main(String[] args) {
		TestExecutor.run(IntAndByteService.class);
	}
	
	@Override
	public void run() {
		int number = 255;
		byte b = Convertor.intToByte(number);
		System.out.println(String.format("byte: %d", b));

		int number1 = Convertor.byteToInt(b);
		System.out.println(String.format("number: %d", number1));

		number = 0;
		b = Convertor.intToByte(number);
		System.out.println(String.format("byte: %d", b));

		number1 = Convertor.byteToInt(b);
		System.out.println(String.format("number: %d", number1));
	}
}