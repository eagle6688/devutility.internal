package devutility.internal.test.service.math.ArithHelper;

import java.math.BigDecimal;
import java.math.RoundingMode;

import devutility.internal.math.ArithHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class DivService extends BaseTest {
	@Override
	public void run() {
		try {
			BigDecimal v1 = ArithHelper.div(10D, 3D, 2, RoundingMode.HALF_UP);
			System.out.println(v1);
			
			BigDecimal v2 = ArithHelper.div(9D, 2D, 2, RoundingMode.HALF_UP);
			System.out.println(v2);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestExecutor.run(DivService.class);
	}
}