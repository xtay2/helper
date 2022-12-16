package helper.util;

import java.util.Set;

public class SetHelper {

	/**
	 * Returns any element of the given {@link Set}.
	 */
	public static <T> T getAny(Set<T> set) {
		return set.iterator().next();
	}
}
