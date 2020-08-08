package devutility.internal.lang;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import devutility.internal.lang.reflect.FieldUtils;
import devutility.internal.lang.reflect.MethodUtils;
import devutility.internal.model.ObjectField;
import devutility.internal.util.CollectionUtils;

/**
 * 
 * ClassUtils
 * 
 * @author: Aldwin Su
 * @version: 2020-01-08 10:53:19
 */
public class ClassUtils {
	/**
	 * Create a new instance.
	 * @param clazz Class object.
	 * @return {@code T}
	 * @throws ReflectiveOperationException from newInstance().
	 */
	public static <T> T newInstance(Class<T> clazz) throws ReflectiveOperationException {
		return clazz.getDeclaredConstructor().newInstance();
	}

	/**
	 * Create a new instance.
	 * @param clazz Class object.
	 * @return {@code T}
	 */
	public static <T> T instance(Class<T> clazz) {
		try {
			return newInstance(clazz);
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Get super classes include itself.
	 * @param clazz Class object
	 * @return {@code List<Class<?>>}
	 */
	public static <T> List<Class<?>> getSuperClasses(Class<T> clazz) {
		List<Class<?>> list = new LinkedList<>();

		if (clazz == null) {
			return list;
		}

		Class<?> temp = clazz;

		while (temp != null && !"java.lang.Object".equals(temp.getCanonicalName())) {
			list.add(temp);
			temp = temp.getSuperclass();
		}

		return list;
	}

	/**
	 * Get all of declared fields include provided class and its super class.
	 * @param clazz Class object.
	 * @return {@code List<Field>}
	 */
	public static List<Field> getAllDeclaredFields(Class<?> clazz) {
		List<Field> list = new LinkedList<>();
		List<Class<?>> classes = getSuperClasses(clazz);

		if (classes.size() == 0) {
			return list;
		}

		for (Class<?> cl : classes) {
			list.addAll(Arrays.asList(cl.getDeclaredFields()));
		}

		return list;
	}

	/**
	 * Get all of declared methods include provided class and its super class.
	 * @param clazz Class object.
	 * @return {@code List<Method>}
	 */
	public static List<Method> getAllDeclaredMethods(Class<?> clazz) {
		List<Method> list = new LinkedList<>();
		List<Class<?>> classes = getSuperClasses(clazz);

		if (classes.size() == 0) {
			return list;
		}

		for (Class<?> cl : classes) {
			list.addAll(Arrays.asList(cl.getDeclaredMethods()));
		}

		return list;
	}

	/**
	 * Get EntityField list.
	 * @param clazz Class object.
	 * @return {@code List<EntityField>}
	 */
	public static List<ObjectField> getEntityFields(Class<?> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Illegal parameter!");
		}

		List<Field> declaredFields = getAllDeclaredFields(clazz);
		List<Method> declaredMethods = getAllDeclaredMethods(clazz);
		List<ObjectField> list = new ArrayList<>(declaredFields.size());

		for (Field declaredField : declaredFields) {
			Method getter = MethodUtils.getter(declaredField, declaredMethods);
			Method setter = MethodUtils.setter(declaredField.getName(), declaredMethods);

			if (setter == null || getter == null) {
				continue;
			}

			ObjectField entityField = new ObjectField();
			entityField.setField(declaredField);
			entityField.setSetter(setter);
			entityField.setGetter(getter);
			entityField.setOrder(FieldUtils.getOrder(declaredField));
			list.add(entityField);
		}

		return list;
	}

	/**
	 * Get EntityFields and include specified fields.
	 * @param includeFields Fields need include.
	 * @param clazz Class object
	 * @return {@code List<EntityField>}
	 */
	public static List<ObjectField> getIncludedEntityFields(Collection<String> includeFields, Class<?> clazz) {
		List<ObjectField> list = getEntityFields(clazz);
		return EntityFieldUtils.includeEntityFields(list, includeFields);
	}

	/**
	 * Get EntityFields and include specified fields.
	 * @param includeFields Fields need include.
	 * @param clazz Class object
	 * @return {@code List<EntityField>}
	 */
	public static List<ObjectField> getIncludedEntityFields(String[] includeFields, Class<?> clazz) {
		Set<String> fields = new HashSet<>(Arrays.asList(includeFields));
		return getIncludedEntityFields(fields, clazz);
	}

	/**
	 * Get EntityFields and exclude specified fields.
	 * @param clazz Class object
	 * @param excludeFields Fields need exclude.
	 * @return {@code List<EntityField>}
	 */
	public static List<ObjectField> getNonExcludedEntityFields(Collection<String> excludeFields, Class<?> clazz) {
		List<ObjectField> list = getEntityFields(clazz);
		return EntityFieldUtils.excludeEntityFields(list, excludeFields);
	}

	/**
	 * Get EntityFields and exclude specified fields.
	 * @param clazz Class object
	 * @param excludeFields Fields need exclude.
	 * @return {@code List<EntityField>}
	 */
	public static List<ObjectField> getNonExcludedEntityFields(String[] excludeFields, Class<?> clazz) {
		Set<String> fields = new HashSet<>(Arrays.asList(excludeFields));
		return getNonExcludedEntityFields(fields, clazz);
	}

	/**
	 * Get EntityFields and exclude fields with specified annotations.
	 * @param clazz Class object.
	 * @param excludeAnnotations Annotations need exclude.
	 * @return {@code List<EntityField>}
	 */
	public static List<ObjectField> getNonExcludedEntityFields(Annotation[] excludeAnnotations, Class<?> clazz) {
		List<ObjectField> list = getEntityFields(clazz);
		List<Annotation> annotations = Arrays.asList(excludeAnnotations);
		return CollectionUtils.list(list, i -> !i.containAnnotations(annotations));
	}

	/**
	 * Get EntityFields which without provided annotation Class objects.
	 * @param annotationClasses Class objects of annotations.
	 * @param clazz Class object.
	 * @return List<EntityField>
	 */
	public static List<ObjectField> getNonAnnotationClassesEntityFields(List<Class<? extends Annotation>> annotationClasses, Class<?> clazz) {
		List<ObjectField> list = getEntityFields(clazz);
		return CollectionUtils.list(list, i -> !i.containAnnotationClasses(annotationClasses));
	}

	/**
	 * Get EntityFields which without provided annotation Class objects.
	 * @param annotationClasses Class objects of annotations.
	 * @param clazz Class object.
	 * @return List<EntityField>
	 */
	public static List<ObjectField> getNonAnnotationClassesEntityFields(Class<? extends Annotation>[] annotationClasses, Class<?> clazz) {
		return getNonAnnotationClassesEntityFields(Arrays.asList(annotationClasses), clazz);
	}

	/**
	 * Get sorted EntityField list.
	 * @param clazz Class object.
	 * @return {@code List<EntityField>}
	 */
	public static List<ObjectField> getSortedEntityFields(Class<?> clazz) {
		List<ObjectField> list = getEntityFields(clazz);
		list.sort(Comparator.comparingInt(ObjectField::getOrder));
		return list;
	}

	/**
	 * Get sorted EntityField list and exclude specified fields.
	 * @param excludeFields EntityField list.
	 * @param clazz Class object.
	 * @return {@code List<EntityField>}
	 */
	public static List<ObjectField> getSortedAndNonExcludedEntityFields(List<String> excludeFields, Class<?> clazz) {
		List<ObjectField> list = getEntityFields(clazz);
		list = EntityFieldUtils.excludeEntityFields(list, excludeFields);
		list.sort(Comparator.comparingInt(ObjectField::getOrder));
		return list;
	}

	/**
	 * Get Method object by provided name and clazz.
	 * @param name Method name.
	 * @param clazz Class object.
	 * @return Method
	 */
	public static Method getMethod(String name, Class<?> clazz) {
		List<Method> methods = getAllDeclaredMethods(clazz);
		return MethodUtils.find(name, methods);
	}

	/**
	 * Return Generic Class object by provided generic type.
	 * @param genericType Type object for generic type.
	 * @return {@code Class<?>}
	 */
	public static Class<?> getGenericClass(Type genericType) {
		if (genericType != null && genericType instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) genericType;
			return (Class<?>) parameterizedType.getActualTypeArguments()[0];
		}

		return null;
	}

	/**
	 * Check whether object is instance of clazz?
	 * @param object Object need check.
	 * @param clazz Target Class object.
	 * @return boolean
	 */
	public static boolean isInstanceOf(Object object, Class<?> clazz) {
		return clazz.isInstance(object) || clazz.isAssignableFrom(object.getClass());
	}

	/**
	 * Whether clazz is Jave class
	 * @param clazz Class object need check.
	 * @return boolean
	 */
	public static boolean isJaveClass(Class<?> clazz) {
		return clazz != null && clazz.getClassLoader() == null;
	}
}