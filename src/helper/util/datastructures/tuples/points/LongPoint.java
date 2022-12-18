package helper.util.datastructures.tuples.points;

import helper.util.datastructures.tuples.Tuple;

public class LongPoint extends Point<Long> {

	public LongPoint(long x, long y) {
		super(x, y);
	}

	public LongPoint(Long x, Long y) {
		super(x, y);
	}

	public LongPoint(Tuple<Long, Long> tuple) {
		super(tuple);
	}

	public LongPoint(long[] tuple) {
		super(tuple[0], tuple[1]);
	}

	public LongPoint(Long[] tuple) {
		super(tuple);
	}

	// Int Support

	public LongPoint(int x, int y) {
		this(x, (long) y);
	}

	public LongPoint(Integer x, Integer y) {
		this(x.longValue(), y.longValue());
	}

	public LongPoint(int[] tuple) {
		this(tuple[0], tuple[1]);
	}

	public LongPoint(Integer[] tuple) {
		this(tuple[0], tuple[1]);
	}

	@Override
	public Point<Long> add(Point<Long> other) {
		return null;
	}

	@Override
	public Point<Long> sub(Point<Long> other) {
		return null;
	}

	@Override
	public Point<Long> mul(Point<Long> other) {
		return null;
	}

	@Override
	public Point<Long> div(Point<Long> other) {
		return null;
	}

	@Override
	public Point<Long> mod(Point<Long> other) {
		return null;
	}

	@Override
	public Point<Long> add(Long other) {
		return null;
	}

	@Override
	public Point<Long> sub(Long other) {
		return null;
	}

	@Override
	public Point<Long> mul(Long other) {
		return null;
	}

	@Override
	public Point<Long> div(Long other) {
		return null;
	}

	@Override
	public Point<Long> mod(Long other) {
		return null;
	}

	@Override
	public Point<Long> abs() {
		return null;
	}

	@Override
	public Point<Long> negate() {
		return null;
	}

}
