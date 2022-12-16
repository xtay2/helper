package helper.reflection;

import java.lang.reflect.*;
import java.util.*;

import helper.misc.*;
import helper.util.*;

public class ReflectionHelper {

	/**
	 * Returns a new instance of a class, without calling a constructor.
	 *
	 * This method will return {@link Optional#empty()} if an error occurs or
	 * either null, a primitive class, an interface or an abstract class gets passed.
	 */
	public static <T> Optional<T> instance(Class<T> cls) {
		if (cls == null || cls.isPrimitive() || cls.isInterface() || Modifier.isAbstract(cls.getModifiers()))
			return Optional.empty();
		try {
			return Optional.of(cls.cast(UnsafeHelper.instance().get().allocateInstance(cls)));
		} catch (@SuppressWarnings("unused") Exception e) {
			return Optional.empty();
		}
	}

	/**
	 * Returns the name of the method that is calling this one.
	 */
	public static String methodName() {
		return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE) //
				.walk(frame -> frame.skip(1).findFirst()).get() //
				.getMethodName();
	}

	/**
	 * Tries to call methods that the jdk marks as "forbidden".
	 *
	 * @param clsPath is the package-path of the class, for example "java.util.String".
	 * @param methodName is the name of the targetted method.
	 * @param params are the values that get passed as parameters.
	 * @return the return value or null, if the target method is a void.
	 *
	 * @throws IllegalAccessException if the invocation is really locked.
	 * @throws InvocationTargetException if an exception occured due to unexpected parameters.
	 * @throws NoSuchMethodException if the methodName doesn't exist.
	 * @throws ClassNotFoundException if the classPath doesn't exist.
	 * @throws SecurityException see {@link Class#getMethod(String, Class...)}
	 */
	public static Object callForbiddenMethod(String clsPath, String methodName, Object... params)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		var cls = Class.forName(clsPath);
		var method = params.length > 0 ? cls.getMethod(methodName, ArrayHelper.map(params, Object::getClass)) : cls.getMethod(methodName);
		method.trySetAccessible();
		return Modifier.isStatic(method.getModifiers()) ? method.invoke(null, params)
				: method.invoke(ReflectionHelper.instance(cls), params);
	}

}
