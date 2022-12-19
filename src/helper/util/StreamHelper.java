package helper.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class StreamHelper {

	/**
	 * Creates a new {@link Stream} of the given length and maps it with the given element.
	 */
	public static <T> Stream<T> generator(IntFunction<T> mapper, long count) {
		return IntStream.iterate(0, i -> i + 1).limit(count).mapToObj(mapper);
	}

	/**
	 * Reverses the given {@link Stream}.
	 * <p>
	 * This assumes that the given {@link Stream} is sequential.
	 */
	public static <T> Stream<T> reverse(Stream<T> stream) {
		return stream.collect(Collector.of(
				() -> new ArrayDeque<T>(),
				ArrayDeque::addFirst,
				(d1, d2) -> {
					d2.addAll(d1);
					return d2;
				})
		).stream();
	}

	/**
	 * Reverses the given {@link IntStream}.
	 * <p>
	 * This assumes that the given {@link IntStream} is sequential.
	 */
	public static <T> IntStream reverse(IntStream stream) {
		return reverse(stream.boxed()).mapToInt(Integer::intValue);
	}

	/**
	 * Like {@link Stream#takeWhile(Predicate)}, but the first element for which the predicate fails is included.
	 */
	public static <T> Stream<T> takeWhileIncl(Stream<T> stream, Predicate<T> pred) {
		var res = new ArrayList<T>();
		for (var e : stream.toList()) {
			res.add(e);
			if (pred.test(e))
				continue;
			break;
		}
		return res.stream();
	}

	/**
	 * Groups the elements of the given stream into arrays of the given size.
	 * <p>
	 * If the length of the stream is not a multiple of the given size, the last array will contain null values.
	 */
	@SuppressWarnings("unchecked")
	public static <T> Stream<T[]> group(Stream<T> stream, int size) {
		return stream.collect(Collector.of(
				() -> new ArrayDeque<T>(),
				ArrayDeque::add,
				(d1, d2) -> {
					d1.addAll(d2);
					return d1;
				},
				d -> {
					var res = new ArrayList<T[]>();
					while (!d.isEmpty()) {
						var arr = (T[]) new Object[size];
						for (int i = 0; i < size; i++)
							arr[i] = d.poll();
						res.add(arr);
					}
					return res.stream();
				})
		);
	}

	public static <T, R> Stream<R> mapIndexed(Stream<T> stream, BiFunction<T, Integer, R> mapper) {
		var lst = stream.toList();
		return IntStream.range(0, lst.size()).mapToObj(i -> mapper.apply(lst.get(i), i));
	}

	/**
	 * Maps this stream to groups of the previous neighbours of each element.
	 *
	 * @param groupSize          is the maximum size of the groups.
	 * @param includeCurrent     if true, the current element is included in the group.
	 * @param allowNonFullGroups if true, the first few groups may be smaller than the group size.
	 */
	public static <T> Stream<T[]> groupPrev(Stream<T> stream, int groupSize, boolean includeCurrent, boolean allowNonFullGroups) {
		// TODO: Implement me!
		return null;
	}

	/**
	 * Maps this stream to groups of the next neighbours of each element.
	 *
	 * @param groupSize          is the maximum size of the groups.
	 * @param includeCurrent     if true, the current element is included in the group.
	 * @param allowNonFullGroups if true, the last few groups may be smaller than the group size.
	 */
	public static <T> Stream<T[]> groupNext(Stream<T> stream, int groupSize, boolean includeCurrent, boolean allowNonFullGroups) {
		// TODO: Implement me!
		return null;
	}
}
