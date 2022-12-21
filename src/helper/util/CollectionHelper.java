package helper.util;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionHelper {

	/**
	 * Maps all elements in a Collection to a String and joins them together.
	 */
	public static <T> String mapJoin(Collection<T> c, Function<T, String> toString, String delimiter) {
		return c.stream().map(toString).collect(Collectors.joining(delimiter));
	}

}
