package devutility.internal.test.util.propertiesutils;

import java.lang.reflect.InvocationTargetException;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.data.model.PropertiesModel;
import devutility.internal.util.PropertiesUtils;

public class ToModelTest extends BaseTest {
	@Override
	public void run() {
		try {
			PropertiesModel model = PropertiesUtils.toModel("database.properties", PropertiesModel.class);
			println(model.getLoginName());
			println(model.getPassword());
			println(model.getTimeout());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ToModelTest.class);
	}
}