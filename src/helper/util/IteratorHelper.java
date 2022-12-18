package helper.util;

import java.util.Iterator;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class IteratorHelper {

	/**
	 * Converts an {@link Iterator} into a linear {@link Stream}.
	 */
	public static <E> Stream<E> stream(Iterator<E> iter) {
		return IterableHelper.stream(() -> iter);
	}


}
