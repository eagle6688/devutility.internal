package devutility.internal.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Convertor, add on convertor methods.
 * 
 * @author: Aldwin Su
 * @creation: 2019-03-05 18:32:27
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Convertor {

}