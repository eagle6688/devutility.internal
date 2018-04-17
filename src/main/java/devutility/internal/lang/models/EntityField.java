package devutility.internal.lang.models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import devutility.internal.lang.reflect.FieldUtils;
import devutility.internal.lang.reflect.MethodUtils;

public class EntityField {
	private Field field;
	private Method setter;
	private Method getter;

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

	public Object getValue(Object model) throws ReflectiveOperationException {
		return getter.invoke(model);
	}

	public boolean containAnnotations(List<Annotation> annotations) {
		if (FieldUtils.contain(field, annotations)) {
			return true;
		}

		if (MethodUtils.contain(setter, annotations)) {
			return true;
		}

		if (MethodUtils.contain(getter, annotations)) {
			return true;
		}

		return false;
	}
}