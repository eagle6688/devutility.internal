package devutility.internal.lang.models;

import java.lang.reflect.Method;

import java.lang.reflect.Field;

public class EntityField {
	private Field field;
	private Method setter;

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
}