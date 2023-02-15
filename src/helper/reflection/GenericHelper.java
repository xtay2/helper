package helper.reflection;

import helper.util.ArrayHelper;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public class GenericHelper {

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
			}, Class[]::new);
		} catch (@SuppressWarnings("unused") ClassCastException e) {
			return new Class<?>[0];
		}
	}
}