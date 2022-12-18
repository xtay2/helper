package helper.base;

import helper.util.IteratorHelper;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassHelper {

	/**
	 * Returns every {@link Field} in this class and all of its parent-classes.
	 * This includes synthetic fields.
	 */
	public static Set<Field> allFieldsOf(Class<?> cls) {
		return superclassStream(cls) //
				.flatMap(c -> Stream.of(c.getDeclaredFields())) //
				.collect(Collectors.toSet());
	}

	/** Returns a {@link Stream} of this class and all of its superclasses including {@link Object}. */
	public static Stream<Class<?>> superclassStream(Class<?> cls) {
		return IteratorHelper.stream(superclassIter(cls));
	}

	/**
	 * Returns a {@link Iterator} of this class and all of its superclasses including {@link Object}.
	 */
	public static Iterator<Class<?>> superclassIter(Class<?> cls) {
		return new Iterator<>() {

			private Class<?> current = cls;

			@Override
			public boolean hasNext() {
				return !Object.class.equals(current);
			}

			@Override
			public Class<?> next() {
				return current = current.getSuperclass();
			}

		};
	}

}
