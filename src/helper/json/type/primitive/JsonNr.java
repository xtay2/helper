package helper.json.type.primitive;

import java.math.*;
import java.util.*;

import helper.base.*;

public final class JsonNr extends Number implements JsonPrimitive, Comparable<Number> {
	
	private final Number val;
	
	public JsonNr(Number val) {
		if (NumberHelper.isConceptual(val))
			throw new NumberFormatException("Json doesn't allow the value \"" + val + "\".");
		this.val = Objects.requireNonNull(val);
	}
	
	// Object

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Number n //
				&& !NumberHelper.isConceptual(n) //
				&& bigDecValue().equals(new JsonNr(n).bigDecValue());
	}

	@Override
	public int hashCode() {
		return val.hashCode();
	}
	
	// Comparable
	
	@Override
	public int compareTo(Number o) {
		return bigDecValue().compareTo(new JsonNr(o).bigDecValue());
	}
	
	// Value-Methods

	@Override
	public int intValue() {
		return val.intValue();
	}
	
	@Override
	public long longValue() {
		return val.longValue();
	}
	
	@Override
	public float floatValue() {
		return val.floatValue();
	}
	
	@Override
	public double doubleValue() {
		return val.doubleValue();
	}
	
	public BigInteger bigIntValue() {
		return bigDecValue().toBigInteger();
	}
	
	public BigDecimal bigDecValue() {
		return new BigDecimal(val.toString());
	}
	
	// toString
	
	@Override
	public String toString() {
		return val.toString();
	}
}
