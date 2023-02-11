package helper.util;

import helper.util.types.Nat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("all")
public class NatTest {

	@Test
	public void testConstructor() {
		assertThrows(AssertionError.class, () -> new Nat(-1));
		assertThrows(AssertionError.class, () -> new Nat(null));
	}

	@Test
	public void testCompareTo() {
		assertThrows(NullPointerException.class, () -> new Nat(0).compareTo(null));

		assertEquals(0, Nat.ZERO.compareTo(Nat.ZERO));
		assertEquals(-1, Nat.ZERO.compareTo(Nat.ONE));
		assertEquals(1, Nat.ONE.compareTo(Nat.ZERO));

		assertEquals(0, Nat.ZERO.compareTo(0));
		assertEquals(-1, Nat.ZERO.compareTo(1));
		assertEquals(1, Nat.ONE.compareTo(0));

		assertEquals(0, Nat.INF.compareTo(Nat.INF));
		assertEquals(-1, Nat.ZERO.compareTo(Nat.INF));
		assertEquals(1, Nat.INF.compareTo(Nat.ZERO));

		assertEquals(0, Nat.INF.compareTo(Double.POSITIVE_INFINITY));
		assertEquals(-1, Nat.ZERO.compareTo(Double.POSITIVE_INFINITY));
		assertEquals(1, Nat.INF.compareTo(Double.NEGATIVE_INFINITY));
	}

	@Test
	public void testAdd() {
		assertEquals(Nat.ZERO, Nat.ZERO.add(Nat.ZERO));
		assertEquals(Nat.ONE, Nat.ZERO.add(Nat.ONE));
		assertEquals(Nat.ONE, Nat.ONE.add(Nat.ZERO));
		assertEquals(Nat.INF, Nat.ZERO.add(Nat.INF));
		assertEquals(Nat.INF, Nat.INF.add(Nat.ZERO));
		assertEquals(Nat.INF, Nat.INF.add(Nat.INF));
		assertEquals(Nat.INF, Nat.INF.add(Nat.ONE));
		assertEquals(Nat.INF, Nat.ONE.add(Nat.INF));
	}

	@Test
	public void testEquals() {
		assertEquals(Nat.ZERO, Nat.ZERO);
		assertEquals(Nat.ONE, Nat.ONE);
		assertEquals(Nat.INF, Nat.INF);
	}

	@Test
	public void testHashCode() {
		assertEquals(Nat.ZERO.hashCode(), Nat.ZERO.hashCode());
		assertEquals(Nat.ONE.hashCode(), Nat.ONE.hashCode());
		assertEquals(Nat.INF.hashCode(), Nat.INF.hashCode());
	}

}