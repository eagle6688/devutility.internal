package devutility.internal.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * Order for field in Java entity class.
 * 
 * @author: Lenovo
 * @version: 2019-06-05 15:10:55
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface Order {
	/**
	 * Field order value
	 * @return int
	 */
	int value();
}