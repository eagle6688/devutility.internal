package devutility.internal.basic.math;

import java.math.BigDecimal;

public class FloatTest {
	public static void main(String[] args) {
		System.out.println(0.06 + 0.01);
		System.out.println(2.0 - 1.1);

		System.out.println(BigDecimal.valueOf(2, 0).subtract(BigDecimal.valueOf(11, 1)));

		BigDecimal aDouble = new BigDecimal(1.22);
		System.out.println("construct with a double value: " + aDouble);

		BigDecimal aDouble2 = new BigDecimal(Double.valueOf(1.22));
		System.out.println("construct with a double 2 value: " + aDouble2);

		BigDecimal aDouble3 = new BigDecimal(Double.toString(1.22));
		System.out.println("construct with a double 3 value: " + aDouble3);
		
		BigDecimal aDouble4 = BigDecimal.valueOf(1.22);
		System.out.println("construct with a double 4 value: " + aDouble4);

		BigDecimal aString = new BigDecimal("1.22");
		System.out.println("construct with a String value: " + aString);

		BigDecimal a = new BigDecimal("1.22");
		System.out.println("construct with a String value: " + a);

		BigDecimal b = new BigDecimal("2.22");
		a.add(b);
		System.out.println("aplus b is : " + a);
	}
}