package helper.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ListHelper {

	/**
	 * Performs a mapping operation on a single index of a {@link List}.
	 */
	public static <T> List<T> map(List<T> list, int idx, Function<T, T> mapper) {
		list.set(idx, mapper.apply(list.get(idx)));
		return list;
	}

	/**
	 * Creates a new {@link List} of the given length and fills it with the given element.
	 */
	public static <T> List<T> generator(T value, int length) {
		return generator(() -> value, length);
	}

	/**
	 * Creates a new {@link List} of the given length and executes the supplier on each element.
	 */
	public static <T> List<T> generator(Supplier<T> value, int length) {
		return new ArrayList<>() {{
			for (int i = 0; i < length; i++)
				add(value.get());
		}};
	}
}
