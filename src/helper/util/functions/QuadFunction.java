package helper.util.functions;

import java.util.function.*;

/**
 * Represents a function that accepts four arguments and produces a result.
 *
 * @see Function
 * @see BiFunction
 * @see TriFunction
 */
@FunctionalInterface
public interface QuadFunction<T1, T2, T3, T4, R> {

	/**
	 * Applies this function to the given argument.
	 *
	 * @param t1 the first function argument.
	 * @param t2 the second function argument.
	 * @param t3 the third function argument.
	 * @param t4 the fourth function argument.
	 * @return the function result
	 */
	R apply(T1 t1, T2 t2, T3 t3, T4 t4);

}