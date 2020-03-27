package devutility.internal.util.propertiesutils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import devutility.internal.model.PropertiesModel;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.PropertiesUtils;

public class ToModelTest extends BaseTest {
	@Override
	public void run() {
		try {
			PropertiesModel model = PropertiesUtils.toObjectFromResource("database.properties", PropertiesModel.class);
			println(model.getLoginName());
			println(model.getPassword());
			println(model.getTimeout());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ToModelTest.class);
	}
}