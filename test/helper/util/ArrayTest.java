package helper.util;

import org.junit.jupiter.api.Test;

import static helper.util.ArrayHelper.map;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** {@link ArrayHelper} */
public class ArrayTest {

	@Test
	public void testMap() {
		String[] a1 = {"2", "4", "6", "8"};
		Integer[] a2 = {1, 2, 3, 4};
		assertEquals(a1, map(a2, e -> String.valueOf(e * 2), String[]::new));
	}

}
