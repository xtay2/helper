package helper.util.datastructures.tuples.points;

import helper.util.annotations.DataStructure;
import helper.util.datastructures.tuples.Tuple;

@DataStructure(mutable = false, fixedSize = true, fixedType = true, threadSafe = true, lazy = false)
@SuppressWarnings("unused")
public class IntPoint extends Point<Integer> {

	public IntPoint(int x, int y) {
		super(x, y);
	}

	public IntPoint(Integer x, Integer y) {
		super(x, y);
	}

	public IntPoint(Tuple<Integer, Integer> tuple) {
		super(tuple);
	}

	public IntPoint(int[] tuple) {
		super(tuple[0], tuple[1]);
	}

	public IntPoint(Integer[] tuple) {
		super(tuple);
	}

	@Override
	public Point<Integer> add(Point<Integer> other) {
		return new IntPoint(x + other.x, y + other.y);
	}

	@Override
	public Point<Integer> sub(Point<Integer> other) {
		return new IntPoint(x - other.x, y - other.y);
	}

	@Override
	public Point<Integer> mul(Point<Integer> other) {
		return new IntPoint(x * other.x, y * other.y);
	}

	@Override
	public Point<Integer> div(Point<Integer> other) {
		return new IntPoint(x / other.x, y / other.y);
	}

	@Override
	public Point<Integer> mod(Point<Integer> other) {
		return new IntPoint(x % other.x, y % other.y);
	}

	@Override
	public Point<Integer> add(Integer other) {
		return new IntPoint(x + other, y + other);
	}

	@Override
	public Point<Integer> sub(Integer other) {
		return new IntPoint(x - other, y - other);
	}

	@Override
	public Point<Integer> mul(Integer other) {
		return new IntPoint(x * other, y * other);
	}

	@Override
	public Point<Integer> div(Integer other) {
		return new IntPoint(x / other, y / other);
	}

	@Override
	public Point<Integer> mod(Integer other) {
		return new IntPoint(x % other, y % other);
	}

	@Override
	public Point<Integer> abs() {
		return new IntPoint(Math.abs(x), Math.abs(y));
	}

	@Override
	public Point<Integer> negate() {
		return new IntPoint(-x, -y);
	}
}
