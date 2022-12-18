package helper.util;

/** {@link ArrayHelper} */
public class ArrayTest {

	@Test
	public void testMap() {
		String[] a1 = {"2", "4", "6", "8"};
		Integer[] a2 = {1, 2, 3, 4};
		assertEquals(a1, ArrayHelper.map(a2, e -> String.valueOf(e * 2)));
	}

}
