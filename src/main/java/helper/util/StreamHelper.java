package helper.util;

import java.util.*;
import java.util.stream.*;

public class StreamHelper {

	/**
	 * Converts an {@link Iterable} into a linear {@link Stream}.
	 */
	public static <E> Stream<E> stream(Iterable<E> iter) {
		return StreamSupport.stream(iter.spliterator(), false);
	}

	/**
	 * Converts an {@link Iterator} into a linear {@link Stream}.
	 */
	public static <E> Stream<E> stream(Iterator<E> iter) {
		return stream(() -> iter);
	}
}
