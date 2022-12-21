package helper.util;

import java.util.Objects;

@SuppressWarnings("unused")
public class ComparableHelper {

	/**
	 * Compares two comparables of the same type.
	 *
	 * @throws IllegalStateException If at least one of the passed values is not comparable.
	 * @throws ClassCastException    If both types are comparable but not with each other.
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static <T> Integer forceCompare(T a, T b) {
		if (a.getClass().equals(b.getClass()) && a instanceof Comparable c1 && b instanceof Comparable c2)
			return Objects.compare(c1, c2, Comparable::compareTo);
		return null;
	}
}
