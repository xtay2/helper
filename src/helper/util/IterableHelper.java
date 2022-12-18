package helper.util;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@SuppressWarnings("unused")
public class IterableHelper {


	/**
	 * Converts an {@link Iterable} into a linear {@link Stream}.
	 */
	public static <E> Stream<E> stream(Iterable<E> iter) {
		return StreamSupport.stream(iter.spliterator(), false);
	}

}
