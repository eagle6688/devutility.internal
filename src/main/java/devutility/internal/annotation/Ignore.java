package devutility.internal.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * Ignore, add on fields that need ignore.
 * 
 * @author: Aldwin Su
 * @creation: 2019-12-05 22:21:40
 */
@Inherited
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD })
public @interface Ignore {

}