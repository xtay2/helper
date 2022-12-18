package helper.json.type.primitive;

import static org.junit.jupiter.api.Assertions.*;

import java.math.*;

import org.junit.jupiter.api.*;

import helper.json.type.*;

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
	
	@Override
	@Test
	public void toStringTest() {
		// TODO Implement me!
	}
	
	@Override
	@Test
	public void toPrettyStringTest() {
		// TODO Implement me!
	}

}
