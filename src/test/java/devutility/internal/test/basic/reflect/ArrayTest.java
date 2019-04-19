package devutility.internal.test.basic.reflect;

public class ArrayTest {
	public static void main(String[] args) {
		// The method isArray in Class instance
		Class<?> cl = String.class;
		System.out.println(String.format("%s is %s", cl.getName(), cl.isArray() ? "array!" : "not array!"));

		String[] array = { "1", "asd", "123" };
		System.out.println(String.format("%s is %s", array.getClass().getName(), array.getClass().isArray() ? "array!" : "not array!"));
		System.out.println(array.getClass().getComponentType().getName());
	}
}