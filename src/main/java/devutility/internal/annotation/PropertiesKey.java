package devutility.internal.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * PropertiesKey
 * 
 * @author: Aldwin Su
 * @creation: 2018-08-01 16:04:04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PropertiesKey {
	/**
	 * Properties key name.
	 * @return String
	 */
	String value();
}