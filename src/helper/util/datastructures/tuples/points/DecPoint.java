package helper.util.datastructures.tuples.points;

import helper.util.annotations.DataStructure;
import helper.util.datastructures.tuples.Tuple;

import java.math.BigDecimal;
import java.math.MathContext;

@DataStructure(mutable = false, fixedSize = true, fixedType = true, threadSafe = true, lazy = false)
@SuppressWarnings("unused")
public class DecPoint extends Point<BigDecimal> {

	private static final MathContext MATH_CONTEXT = MathContext.DECIMAL128;

	public DecPoint(int x, int y) {
		super(BigDecimal.valueOf(x), BigDecimal.valueOf(y));
	}

	public DecPoint(long x, long y) {
		super(BigDecimal.valueOf(x), BigDecimal.valueOf(y));
	}

	public DecPoint(double x, double y) {
		super(BigDecimal.valueOf(x), BigDecimal.valueOf(y));
	}

	public DecPoint(BigDecimal x, BigDecimal y) {
		super(x, y);
	}

	public DecPoint(Tuple<BigDecimal, BigDecimal> tuple) {
		super(tuple);
	}

	public DecPoint(BigDecimal[] tuple) {
		super(tuple);
	}

	@Override
	public Point<BigDecimal> add(Point<BigDecimal> other) {
		return new DecPoint(x.add(other.x), y.add(other.y));
	}

	@Override
	public Point<BigDecimal> sub(Point<BigDecimal> other) {
		return new DecPoint(x.subtract(other.x), y.subtract(other.y));
	}

	@Override
	public Point<BigDecimal> mul(Point<BigDecimal> other) {
		return new DecPoint(x.multiply(other.x), y.multiply(other.y));
	}

	@Override
	public Point<BigDecimal> div(Point<BigDecimal> other) {
		return new DecPoint(x.divide(other.x, MATH_CONTEXT), y.divide(other.y, MATH_CONTEXT));
	}

	@Override
	public Point<BigDecimal> mod(Point<BigDecimal> other) {
		return new DecPoint(x.remainder(other.x), y.remainder(other.y));
	}

	@Override
	public Point<BigDecimal> add(BigDecimal other) {
		return new DecPoint(x.add(other), y.add(other));
	}

	@Override
	public Point<BigDecimal> sub(BigDecimal other) {
		return new DecPoint(x.subtract(other), y.subtract(other));
	}

	@Override
	public Point<BigDecimal> mul(BigDecimal other) {
		return new DecPoint(x.multiply(other), y.multiply(other));
	}

	@Override
	public Point<BigDecimal> div(BigDecimal other) {
		return new DecPoint(x.divide(other, MATH_CONTEXT), y.divide(other, MATH_CONTEXT));
	}

	@Override
	public Point<BigDecimal> mod(BigDecimal other) {
		return new DecPoint(x.remainder(other), y.remainder(other));
	}

	@Override
	public Point<BigDecimal> abs() {
		return new DecPoint(x.abs(), y.abs());
	}

	@Override
	public Point<BigDecimal> negate() {
		return new DecPoint(x.negate(), y.negate());
	}
}
