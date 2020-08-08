package devutility.internal.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import devutility.internal.lang.reflect.FieldUtils;
import devutility.internal.lang.reflect.MethodUtils;

/**
 * 
 * ObjectField
 * 
 * @author: Aldwin Su
 * @creation: 2018-03-20 23:55:03
 */
public class ObjectField {
	private int order;
	private Field field;
	private Method setter;
	private Method getter;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

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