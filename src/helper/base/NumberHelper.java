package helper.base;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberHelper {

	/**
	 * Returns if a number is negative.
	 */
	public static boolean isNegative(Number number) {
		return switch (number) {
			case Byte b ->  b < 0;
			case Short s -> s < 0;
			case Integer i -> i < 0;
			case Long l -> l < 0;
			case Float f -> f < 0;
			case Double d -> d < 0;
			case BigInteger bi -> bi.compareTo(BigInteger.ZERO) < 0;
			case BigDecimal bd -> bd.compareTo(BigDecimal.ZERO) < 0;
			default -> throw new IllegalArgumentException("Number type not supported: " + number.getClass());
		};
	}

	/**
	 * Returns true if the passed parameter equals one of the following values:
	 * <pre>
	 * {@link Double#POSITIVE_INFINITY}
	 * {@link Double#NEGATIVE_INFINITY}
	 * {@link Double#NaN}
	 * {@link Float#POSITIVE_INFINITY}
	 * {@link Float#NEGATIVE_INFINITY}
	 * {@link Float#NaN}
	 * </pre>
	 */
	public static boolean isConceptual(Number n) {
		return isInfinite(n) || isNaN(n);
	}
	
	/**
	 * Returns true if the passed parameter equals one of the following values:
	 * <pre>
	 * {@link Double#POSITIVE_INFINITY}
	 * {@link Double#NEGATIVE_INFINITY}
	 * {@link Float#POSITIVE_INFINITY}
	 * {@link Float#NEGATIVE_INFINITY}
	 * </pre>
	 */
	public static boolean isInfinite(Number n) {
		return Float.isInfinite(n.floatValue()) || Double.isInfinite(n.doubleValue());
	}
	
	/**
	 * Returns true if the passed parameter equals one of the following values:
	 * <pre>
	 * {@link Double#NaN}
	 * {@link Float#NaN}
	 * </pre>
	 */
	public static boolean isNaN(Number n) {
		return Float.isNaN(n.floatValue()) || Double.isNaN(n.doubleValue());
	}
	
}
