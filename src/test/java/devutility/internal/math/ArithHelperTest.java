package devutility.internal.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

import devutility.internal.math.ArithHelper;

public class ArithHelperTest {
	public static void main(String[] args) throws IllegalAccessException {
		BigDecimal v1 = ArithHelper.div(10D, 3D, 2, RoundingMode.HALF_UP);
		System.out.println(v1);
		
		BigDecimal v2 = ArithHelper.div(9D, 2D, 2, RoundingMode.HALF_UP);
		System.out.println(v2);
	}
}