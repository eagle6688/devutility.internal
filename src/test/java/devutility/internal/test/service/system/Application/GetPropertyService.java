package devutility.internal.test.service.system.Application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

import devutility.internal.io.DirectoryHelper;
import devutility.internal.system.Application;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

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
	
	public static void main(String[] args) {
		ServiceExecutor.run(GetPropertyService.class);
	}
}