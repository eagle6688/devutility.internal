package devutility.internal.service.system.Application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

import devutility.internal.io.DirectoryHelper;
import devutility.internal.system.Application;
import devutility.internal.test.BaseService;

public class GetPropertyService extends BaseService {
	@Override
	public void run() {
		try {
			String path = Paths.get(DirectoryHelper.getResourcesDirectory(), "system.properties").toString();
			println(Application.getProperty(path, "test"));
			println(Application.getProperty(path, "Test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}