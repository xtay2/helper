package helper.base;

import java.util.Objects;

@SuppressWarnings("unused")
public class MathHelper {

	/** Finds the smallest number in an array. */
	@SafeVarargs
	public static <T extends Number & Comparable<T>> T min(T... numbers) {
		if (numbers.length == 0)
			return null;
		T min = numbers[0];
		for (T e : numbers) {
			if (e != null && Objects.compare(e, min, Comparable::compareTo) < 0)
				min = e;
		}
		return min;
	}

	/** Finds the smallest int in an array. */
	public static int minInt(int... numbers) {
		if (numbers.length == 0)
			return 0;
		int min = numbers[0];
		for (int e : numbers) {
			if (e < min)
				min = e;
		}
		return min;
	}

	/** Finds the greatest number in an array. */
	@SafeVarargs
	public static <T extends Number & Comparable<T>> T max(T... numbers) {
		if (numbers.length == 0)
			return null;
		T min = numbers[0];
		for (T e : numbers) {
			if (e != null && Objects.compare(e, min, Comparable::compareTo) > 0)
				min = e;
		}
		return min;
	}

	/** Finds the greatest int in an array. */
	public static int maxInt(int... numbers) {
		if (numbers.length == 0)
			return 0;
		int max = numbers[0];
		for (int e : numbers) {
			if (e > max)
				max = e;
		}
		return max;
	}
}

