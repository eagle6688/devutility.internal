package devutility.internal.lang.models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import devutility.internal.lang.reflect.FieldUtils;
import devutility.internal.lang.reflect.MethodUtils;

/**
 * 
 * EntityField
 * 
 * @author: Aldwin Su
 * @version: 2019-06-05 15:24:00
 */
public class EntityField {
	private Field field;
	private Method setter;
	private Method getter;
	private int order;

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Method getSetter() {
		return setter;
	}

	public void setSetter(Method setter) {
		this.setter = setter;
	}

	public Method getGetter() {
		return getter;
	}

	public void setGetter(Method getter) {
		this.getter = getter;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * Get value by calling getter method.
	 * @param obj Object.
	 * @return Object
	 * @throws IllegalAccessException from invoke.
	 * @throws IllegalArgumentException from invoke.
	 * @throws InvocationTargetException from invoke.
	 */
	public Object getValue(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (getter == null) {
			return null;
		}

		return getter.invoke(obj);
	}

	/**
	 * Whether the current field, setter or getter contain provided annotations?
	 * @param annotations Annotation collection.
	 * @return boolean
	 */
	public boolean containAnnotations(Collection<Annotation> annotations) {
		if (FieldUtils.containAnnotations(field, annotations)) {
			return true;
		}

		if (MethodUtils.containAnnotations(setter, annotations)) {
			return true;
		}

		if (MethodUtils.containAnnotations(getter, annotations)) {
			return true;
		}

		return false;
	}

	/**
	 * Whether the current field, setter or getter contain provided annotation Class objects?
	 * @param annotationClasses Class objects of annotations.
	 * @return boolean
	 */
	public boolean containAnnotationClasses(Collection<Class<? extends Annotation>> annotationClasses) {
		if (FieldUtils.containAnnotationClasses(field, annotationClasses)) {
			return true;
		}

		if (MethodUtils.containAnnotationClasses(setter, annotationClasses)) {
			return true;
		}

		if (MethodUtils.containAnnotationClasses(getter, annotationClasses)) {
			return true;
		}

		return false;
	}

	public Class<?> fieldType() {
		return getField() != null ? getField().getType() : null;
	}
}