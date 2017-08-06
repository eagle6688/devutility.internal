package devutility.internal.system;

public class SystemHelper {
	public static String getNewLineChar() {
		return System.getProperty("line.separator");
	}
	
    public static String getPathSeparator() {
    	return System.getProperty("path.separator");
    }
    
    public static String getFileSeparator() {
    	return System.getProperty("file.separator");
    }
}