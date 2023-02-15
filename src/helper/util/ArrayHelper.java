package helper.util;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class ArrayHelper {

	/** Checks if the passed array contains the passed object. */
	public static <T> boolean contains(T[] arr, T obj) {
		for (T t : arr)
			if (t.equals(obj))
				return true;
		return false;
	}

	public static <T> T[] reverse(T[] array) {
		return Stream.of(array).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
			Collections.reverse(list);
			return list.toArray(array);
		}));
	}
	
	/**
	 * Creates a new array and invokes the passed function on every element.
	 * (Similar to {@link Stream#map(Function)})
	 */
	public static <T, R> R[] map(T[] arr, Function<T, R> func, Function<Integer, R[]> supplier) {
		R[] res = supplier.apply(arr.length);
		for (int i = 0; i < res.length; i++)
			res[i] = func.apply(arr[i]);
		return res;
	}

	/** Converts an array to a {@link List}. */
	public static <S> List<S> toList(S[] children) {
		List<S> res = new ArrayList<>(children.length);
		Collections.addAll(res, children);
		return res;
	}

	/** Converts an array to a {@link Set}. */
	public static <S> Set<S> toSet(S[] children) {
		Set<S> res = new HashSet<>(children.length);
		Collections.addAll(res, children);
		return res;
	}

	/** Returns a shallow copy of the passed array. */
	public static <T> T[] subarray(T[] array, int start, int end) {
		T[] res = Arrays.copyOf(array, end - start);
		System.arraycopy(array, start, res, 0, res.length);
		return res;
	}

	/**
	 * Parses every element in the array to an Integer and returns a {@link Stream} of it.
	 */
	public static IntStream parseIntStream(String[] arr) {
		return Arrays.stream(arr).filter(str -> !str.isBlank()).mapToInt(Integer::parseInt);
	}

	/**
	 * Swaps two values in an array.
	 */
	public static <T> void swap(T[] arr, int i, int j) {
		outOfBounds(arr, true, i, j);
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static <T> void move(T[] arr, int idx, int amount) {
		if (amount == 0)
			return;
		outOfBounds(arr, true, idx);
		T tmp = arr[idx];


		while (idx + amount > arr.length - 1) {
			amount = (idx + amount) - arr.length;
			System.out.println(" -> " + amount);
		}

		while (idx + amount < 0) {
			amount = arr.length + amount;
			System.out.println(" -> " + amount);
		}

		if (amount > 0) {
			System.arraycopy(arr, idx + 1, arr, idx, amount);
			arr[idx + amount] = tmp;
		} else {
			System.arraycopy(arr, idx, arr, idx + 1, -amount);
			arr[idx] = tmp;
		}

		arr[idx + amount] = tmp;

	}

	public static <T> boolean outOfBounds(T[] arr, boolean throwExc, int... idxs) {
		for (var idx : idxs)
			if (idx < 0 || idx >= arr.length) {
				if (throwExc)
					throw new IndexOutOfBoundsException("Index " + idx + " out of bounds for array of length " + arr.length);
				return true;
			}
		return false;
	}

	public static <S, R extends S, T extends S> R fold(T[] arr, BiFunction<T, S, R> combiner) {
		if (arr.length < 2)
			return null;
		if (arr.length == 2)
			return combiner.apply(arr[0], arr[1]);
		return combiner.apply(arr[0], fold(ArrayHelper.subarray(arr, 1, arr.length), combiner));
	}

	/**
	 * Returns an {@link Iterator} for the passed array.
	 */
	public static <T> Iterator<T> iterator(T[] children) {
		return new Iterator<>() {
			int i = 0;

			@Override
			public boolean hasNext() {
				return i < children.length;
			}

			@Override
			public T next() {
				return children[i++];
			}
		};
	}
}
