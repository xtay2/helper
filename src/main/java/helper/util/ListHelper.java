package helper.util;

import java.util.*;
import java.util.function.*;

public class ListHelper {

	/**
	 * Performs a mapping operation on a single index of a {@link List}.
	 */
	public static <T> List<T> map(List<T> list, int idx, Function<T, T> mapper) {
		list.set(idx, mapper.apply(list.get(idx)));
		return list;
	}

}
