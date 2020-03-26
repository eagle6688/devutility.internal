package devutility.internal.data.dbinstanceutils;

import java.io.IOException;
import java.io.InputStream;

import devutility.internal.data.DbInstanceUtils;
import devutility.internal.model.DbInstance;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetInstanceTest extends BaseTest {
	@Override
	public void run() {
		InputStream inputStream = GetInstanceTest.class.getClassLoader().getResourceAsStream("database.properties");
		DbInstance dbInstance = null;

		try {
			dbInstance = DbInstanceUtils.getInstance(inputStream, "mongodb");
		} catch (IOException e) {
			e.printStackTrace();
		}

		println(dbInstance.getUri());
		println(dbInstance.getDatabase());
	}

	public static void main(String[] args) {
		TestExecutor.run(GetInstanceTest.class);
	}
}