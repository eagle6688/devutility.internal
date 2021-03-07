package devutility.internal.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * Convertor, add on convertor methods.
 * 
 * @author: Aldwin Su
 * @creation: 2019-03-05 18:32:27
 */
@Retention(RUNTIME)
@Target({ METHOD })
public @interface Convertor {

}