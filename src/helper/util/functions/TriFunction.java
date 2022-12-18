package helper.util.functions;

import java.util.function.*;

/**
 * Represents a function that accepts three arguments and produces a result.
 *
 * @see Function
 * @see BiFunction
 * @see QuadFunction
 */
@FunctionalInterface
public interface TriFunction<T1, T2, T3, R> {

	/**
	 * Applies this function to the given argument.
	 *
	 * @param t1 the first function argument.
	 * @param t2 the second function argument.
	 * @param t3 the third function argument.
	 * @return the function result
	 */
	R apply(T1 t1, T2 t2, T3 t3);

}
