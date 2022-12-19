package helper.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class ArrayHelper {

	public static <T> T[] reverse(T[] array) {
		return Stream.of(array).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
			Collections.reverse(list);
			return list.toArray(array);
		}));
	}

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

	/** Returns a shallow copy of the passed array. */
	public static <T> T[] subarray(T[] array, int start, int end) {
		T[] res = Arrays.copyOf(array, end - start);
		System.arraycopy(array, start, res, 0, res.length);
		return res;
	}

	/**
	 * Parses every element in the array to an Integer and returns a {@link Stream} of it.
	 */
	public static IntStream parseIntStream(String[] arr) {
		return Arrays.stream(arr).filter(str -> !str.isBlank()).mapToInt(Integer::parseInt);
	}

}
