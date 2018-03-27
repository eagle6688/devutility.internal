package devutility.internal.lang.models;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

	public Object getValue(Object model) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return getter.invoke(model);
	}
}