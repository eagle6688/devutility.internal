package devutility.internal.data.converter.converterutils;

import devutility.internal.data.converter.ConverterUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ObjectTointTest extends BaseTest {
	@Override
	public void run() {
		Long longValue = 999L;
		println(ConverterUtils.objectToint(longValue));

		Short shortValue = 9;
		println(ConverterUtils.objectToint(shortValue));

		Integer integerValue = 199;
		println(ConverterUtils.objectToint(integerValue));

		Double doubleValue = 999.00D;
		println(ConverterUtils.objectToint(doubleValue));

		Float floatValue = 99.99F;
		println(ConverterUtils.objectToint(floatValue));

		String strValue = "100";
		println(ConverterUtils.objectToint(strValue));
	}

	public static void main(String[] args) {
		TestExecutor.run(ObjectTointTest.class);
	}
}