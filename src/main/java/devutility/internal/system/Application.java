package devutility.internal.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {
	// region get property

	public static String getProperty(String path, String key) throws FileNotFoundException, IOException {
		try (FileInputStream fileInputStream = new FileInputStream(path)) {
			Properties properties = new Properties();
			properties.load(fileInputStream);
			return properties.getProperty(key);
		} catch (Exception e) {
			throw e;
		}
	}

	public static String getPropertyByResourceName(String name, String key) {
		try (InputStream inputStream = Application.class.getClassLoader().getResourceAsStream(name)) {
			Properties properties = new Properties();
			properties.load(inputStream);
			return properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// endregion

	// region get int property

	public static int getIntProperty(String path, String key) throws FileNotFoundException, IOException {
		String value = getProperty(path, key);
		return Integer.parseInt(value);
	}

	public static int getIntPropertyByResourceName(String name, String key) {
		String value = getPropertyByResourceName(name, key);
		return Integer.parseInt(value);
	}

	// endregion
}