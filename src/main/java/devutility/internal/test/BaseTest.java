package devutility.internal.test;

/**
 * 
 * BaseTest
 * 
 * @author: Aldwin Su
 */
public abstract class BaseTest {
	/**
	 * Print int value in a new line.
	 * @param value: Int value.
	 */
	protected static void println(int value) {
		System.out.println(value);
	}

	/**
	 * Print long value in a new line.
	 * @param value: Long value.
	 */
	protected static void println(long value) {
		System.out.println(value);
	}

	/**
	 * Print string in a new line.
	 * @param value: String value.
	 */
	protected static void println(String value) {
		System.out.println(value);
	}

	/**
	 * Print string value with specified format in a new line.
	 * @param format: String format.
	 * @param args: Objects.
	 */
	protected static void println(String format, Object... args) {
		println(String.format(format, args));
	}

	/**
	 * Run method, sub class should implement this method.
	 */
	public abstract void run();
}