package helper.util.datastructures.tuples;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public class Pair<T> extends Tuple<T, T> {

	public Pair(T x, T y) {
		super(x, y);
	}

	public Pair(Tuple<T, T> tuple) {
		super(tuple.x, tuple.y);
	}

	public Pair(T[] tuple) {
		super(tuple[0], tuple[1]);
		if (tuple.length != 2)
			throw new IllegalArgumentException("Array has to have length 2, was: " + Arrays.toString(tuple));
	}

	public <R> Pair<R> map(Function<T, R> mapper) {
		return new Pair<>(mapper.apply(x), mapper.apply(y));
	}
	
	public boolean both(Predicate<T> pred) {
		return pred.test(x) && pred.test(y);
	}

}
