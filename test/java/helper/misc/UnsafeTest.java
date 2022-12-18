package helper.misc;

import java.util.Optional;

/** {@link UnsafeHelper} */
public class UnsafeTest {

	@Test
	public void testInstance() {
		assertNotEquals(Optional.empty(), UnsafeHelper.instance());
	}
}
