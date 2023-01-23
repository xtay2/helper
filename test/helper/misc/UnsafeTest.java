package helper.misc;


import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


/**
 * {@link UnsafeHelper}
 */
public class UnsafeTest {

	@Test
	public void testInstance() {
		assertNotEquals(Optional.empty(), UnsafeHelper.instance());
	}
}
