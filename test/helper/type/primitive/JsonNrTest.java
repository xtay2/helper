package helper.type.primitive;

import helper.json.type.primitive.JsonNr;
import helper.type.JsonElementTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonNrTest implements JsonElementTest {

	@Test
	public void testConstructor() {
		assertThrows(NumberFormatException.class, () -> new JsonNr(Double.POSITIVE_INFINITY));
		assertThrows(NumberFormatException.class, () -> new JsonNr(Double.NEGATIVE_INFINITY));
		assertThrows(NumberFormatException.class, () -> new JsonNr(Double.NaN));
		assertThrows(NumberFormatException.class, () -> new JsonNr(Float.POSITIVE_INFINITY));
		assertThrows(NumberFormatException.class, () -> new JsonNr(Float.NEGATIVE_INFINITY));
		assertThrows(NumberFormatException.class, () -> new JsonNr(Float.NaN));
		assertThrows(NullPointerException.class, () -> new JsonNr(null));
	}

	@Test
	public void testBigIntValue() {
		assertEquals(BigInteger.ZERO, new JsonNr(0.5).bigIntValue());
	}

	@Test
	public void testBigDecValue() {
		assertEquals(new BigDecimal("0.5"), new JsonNr(0.5).bigDecValue());
	}

	@Test
	public void toStringTest() {
		// TODO Implement me!
	}

	@Override
	public void toSingleStringTest() {
		// TODO Implement me!
	}

	@Override
	@Test
	public void toPrettyStringTest() {
		// TODO Implement me!
	}

	@Override
	public void toSpreadStringTest() {
		// TODO Implement me!
	}

}
