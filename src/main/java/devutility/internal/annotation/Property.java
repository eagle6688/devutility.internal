package devutility.internal.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * Property annotation.
 * 
 * @author: Aldwin Su
 * @creation: 2018-08-01 16:04:04
 */
@Retention(RUNTIME)
@Target({ TYPE, FIELD })
public @interface Property {
	/**
	 * Property name.
	 * @return String
	 */
	String value();
}