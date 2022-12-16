package helper.util;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayHelper {

	/**
	 * Creates a new array and invokes the passed function on every element.
	 * (Similar to {@link Stream#map(Function)})
	 */
	public static <T, R> R[] map(T[] arr, Function<T, R> func) {
		@SuppressWarnings("unchecked")
		R[] res = (R[]) new Object[arr.length];
		for (int i = 0; i < res.length; i++)
			res[i] = func.apply(arr[i]);
		return res;
	}

	/** Converts an array to a {@link Set}. */
	public static <S> Set<S> toSet(S[] children) {
		return Arrays.stream(children).collect(Collectors.toSet());
	}
}
