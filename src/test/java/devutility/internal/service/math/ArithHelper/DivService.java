package devutility.internal.service.math.ArithHelper;

import java.math.BigDecimal;
import java.math.RoundingMode;

import devutility.internal.math.ArithHelper;
import devutility.internal.test.BaseService;

public class DivService extends BaseService {
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
}