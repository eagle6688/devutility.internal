package devutility.internal.test.service.base.Convertor;

import devutility.internal.base.Convertor;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class IntAndByteService extends BaseService {
	public static void main(String[] args) {
		ServiceExecutor.run(IntAndByteService.class);
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