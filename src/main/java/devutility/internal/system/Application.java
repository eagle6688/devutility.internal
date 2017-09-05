package devutility.internal.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Application {
	//region get property
	
	public static String getProperty(String path, String key) throws FileNotFoundException, IOException {
		try (FileInputStream fileInputStream = new FileInputStream(path)) {
			Properties properties = new Properties();
			properties.load(fileInputStream);
			return properties.getProperty(key);
		} catch (Exception e) {
			throw e;
		}
	}
	
	//endregion

	//region get int property
	
	public static int getIntProperty(String path, String key) throws FileNotFoundException, IOException {
		String value = getProperty(path, key);
		return Integer.parseInt(value);
	}
	
	//endregion
}