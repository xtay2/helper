package helper.reflection;

import java.lang.reflect.*;

import helper.util.*;

public class GenericHelper {

	public static <T> Class<T> getGenericType() { return null; }
	
	/**
	 * Returns all generic types of any field. If the passed field has no generic type information, an
	 * empty array gets returned.
	 */
	public static Class<?>[] getGenericTypesOfField(Field f) {
		try {
			var params = ((ParameterizedType) f.getGenericType()).getActualTypeArguments();
			return ArrayHelper.map(params, param -> {
				try {
					return Class.forName(param.getTypeName());
				} catch (ClassNotFoundException e) {
					throw new AssertionError(e);
				}
			});
		} catch (@SuppressWarnings("unused") ClassCastException e) {
			return new Class<?>[0];
		}
	}
}