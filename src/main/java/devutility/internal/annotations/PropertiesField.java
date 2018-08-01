package devutility.internal.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface PropertiesField {
	/**
	 * Properties name.
	 * @return String
	 */
	String name();
}