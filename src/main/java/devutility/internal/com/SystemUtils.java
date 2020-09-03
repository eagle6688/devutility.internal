package devutility.internal.com;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * SystemUtils
 * 
 * @author: Aldwin Su
 * @creation: 2017-08-06 20:26:49
 */
public class SystemUtils {
	/**
	 * Return value of environment variable and following the rule: 1.If format of "str" does not match our pattern, then
	 * return the str; 2.If format of "str" match pattern ${environment variable name:environment variable default value},
	 * first get environment variable value by "environment variable name", if value = null return "environment variable
	 * default value"; 3.If format of "str" match pattern ${environment variable name}, return environment variable value by
	 * "environment variable name".
	 * @param str format "${[environment variable name]:[environment variable default value]}"
	 * @return String
	 */
	public static String environmentVariable(String str) {
		Matcher matcher = Pattern.compile(Config.REGEX_ENVIRONMENT_VARIABLE).matcher(str);

		if (!matcher.matches() || matcher.groupCount() != 2) {
			return str;
		}

		String name = matcher.group(1);
		String envValue = System.getenv(name);

		if (envValue != null) {
			return envValue;
		}

		return matcher.group(2);
	}

	/**
	 * Get line separator.
	 * @return String
	 */
	public static String lineSeparator() {
		return System.getProperty("line.separator");
	}

	/**
	 * Get path separator.
	 * @return String
	 */
	public static String pathSeparator() {
		return System.getProperty("path.separator");
	}

	/**
	 * Get file separator.
	 * @return String
	 */
	public static String fileSeparator() {
		return System.getProperty("file.separator");
	}

	/**
	 * Return processors count.
	 * @return int
	 */
	public static int processorsCount() {
		return Runtime.getRuntime().availableProcessors();
	}

	/**
	 * Return proper processors count for programe usage.
	 * @return int
	 */
	public static int properProcessorsCount() {
		return processorsCount() * 3 / 4;
	}

	/**
	 * Return a new UUID.
	 * @return String
	 */
	public static String uuid() {
		return UUID.randomUUID().toString();
	}
}