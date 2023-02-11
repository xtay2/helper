package helper.util.types;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/**
 * A natural number with arbitrary size and an infinity-constant.
 * <p>
 * This class is immutable and only supports adding.
 */
@SuppressWarnings("unused")
public final class Nat extends Number implements Comparable<Number> {

	public static final Nat ZERO = new Nat(0);
	public static final Nat ONE = new Nat(1);
	public static final Nat INF = new Nat();

	private final BigInteger value;

	/** Infinity/NAN-Constructor */
	private Nat() {
		value = null;
	}

	public Nat(byte value) {
		this(BigInteger.valueOf(value));
	}

	public Nat(short value) {
		this(BigInteger.valueOf(value));
	}

	public Nat(int value) {
		this(BigInteger.valueOf(value));
	}

	public Nat(long value) {
		this(BigInteger.valueOf(value));
	}

	public Nat(BigInteger value) {
		assert value != null;
		assert value.compareTo(BigInteger.ZERO) >= 0;
		this.value = value;
	}

	@Override
	public int compareTo(Number o) {
		boolean otherIsInf = o instanceof Nat n && n.isInfinite()
				|| o instanceof Float f && f.equals(Float.POSITIVE_INFINITY)
				|| o instanceof Double d && d.equals(Double.POSITIVE_INFINITY);
		if (isInfinite() && otherIsInf)
			return 0;
		if (isInfinite())
			return 1;
		if (otherIsInf)
			return -1;
		return switch (o) {
			case Nat n -> value.compareTo(n.value);
			case BigInteger n -> value.compareTo(n);
			case BigDecimal n -> value.compareTo(n.toBigInteger());
			default -> value.compareTo(BigInteger.valueOf(o.longValue()));
		};
	}

	@Override
	public int intValue() {
		return value.intValue();
	}

	@Override
	public long longValue() {
		return value.longValue();
	}

	@Override
	public float floatValue() {
		return value.floatValue();
	}

	@Override
	public double doubleValue() {
		return value.doubleValue();
	}

	public Nat add(Nat other) {
		if (isInfinite() || other.isInfinite())
			return INF;
		return new Nat(value.add(other.value));
	}

	public boolean isInfinite() {
		return value == null;
	}

	public boolean less(Number other) {
		return compareTo(other) < 0;
	}

	public boolean leq(Number other) {
		return compareTo(other) <= 0;
	}

	public boolean greater(Number other) {
		return compareTo(other) > 0;
	}

	public boolean geq(Number other) {
		return compareTo(other) >= 0;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Number nr && compareTo(nr) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(value);
	}

	@Override
	public String toString() {
		return value == null ? "INF" : value.toString();
	}
}
