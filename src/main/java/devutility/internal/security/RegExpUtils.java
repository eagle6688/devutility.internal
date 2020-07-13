package devutility.internal.security;

/**
 * 
 * RegExpUtils
 * 
 * @author: Aldwin Su
 * @creation: 2020-07-13 17:49:44
 */
public class RegExpUtils {
	public final static String EMAIL = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

	public final static String IP = "((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}";

	public final static String CELLPHONE_CHINA = "^1(3|4|5|7|8)\\d{9}$";

	public final static String UUID = "[0-9a-f]{8}(-[0-9a-f]{4}){3}-[0-9a-f]{12}";
}