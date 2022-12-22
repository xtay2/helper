package helper.util;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionHelper {

	/**
	 * Maps all elements in an Array to a String and joins them together.
	 */
	public static <T> String mapJoin(T[] c, Function<T, String> toString, String delimiter) {
		return mapJoin(Arrays.asList(c), toString, delimiter);
	}

	/**
	 * Maps all elements in an Iterable to a String and joins them together.
	 */
	public static <T> String mapJoin(Iterable<T> c, Function<T, String> toString, String delimiter) {
		return IterableHelper.stream(c).map(toString).collect(Collectors.joining(delimiter));
	}

}
