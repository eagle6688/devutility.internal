package devutility.internal.test.data.dbinstanceutils;

import java.io.InputStream;

import devutility.internal.data.DbInstanceUtils;
import devutility.internal.models.DbInstance;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetInstanceTest extends BaseTest {
	@Override
	public void run() {
		InputStream inputStream = GetInstanceTest.class.getClassLoader().getResourceAsStream("database.properties");
		DbInstance dbInstance = DbInstanceUtils.getInstance(inputStream, "mongodb");
		println(dbInstance.getUri());
		println(dbInstance.getDatabase());
	}

	public static void main(String[] args) {
		TestExecutor.run(GetInstanceTest.class);
	}
}