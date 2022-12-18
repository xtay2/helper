package helper.util.datastructures.tuples.points;

import helper.util.datastructures.tuples.Pair;
import helper.util.datastructures.tuples.Tuple;

public abstract class Point<T extends Number> extends Pair<T> {

	public Point(T x, T y) {
		super(x, y);
	}

	public Point(Tuple<T, T> tuple) {
		super(tuple);
	}

	public Point(T[] tuple) {
		super(tuple);
	}

	public abstract Point<T> add(Point<T> other);

	public abstract Point<T> sub(Point<T> other);

	public abstract Point<T> mul(Point<T> other);

	public abstract Point<T> div(Point<T> other);

	public abstract Point<T> mod(Point<T> other);

	public abstract Point<T> add(T other);

	public abstract Point<T> sub(T other);

	public abstract Point<T> mul(T other);

	public abstract Point<T> div(T other);

	public abstract Point<T> mod(T other);

	public abstract Point<T> abs();

	public abstract Point<T> negate();

	@Override
	public final String toString() {
		return "(" + x + ", " + y + ")";
	}
}
