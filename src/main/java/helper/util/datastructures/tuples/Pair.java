package helper.util.datastructures.tuples;

@SuppressWarnings("unused")
public class Pair<T> extends Tuple<T, T> {

	public Pair(T x, T y) {
		super(x, y);
	}

	public Pair(T[] pair) {
		super(pair[0], pair[1]);
		if(pair.length != 2)
			throw new IllegalArgumentException("Array must have length 2");
	}

}
