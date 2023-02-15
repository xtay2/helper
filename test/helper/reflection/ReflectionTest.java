package helper.reflection;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ReflectionTest {

	private static class TestClass {

		private TestClass() {
			throw new AssertionError();
		}

	}

	@Test
	public void testInstance() {
		var val = ReflectionHelper.instance(TestClass.class);
		assertNotEquals(Optional.empty(), val);
		assertNotEquals(null, val.orElseThrow());
	}

	@Test
	public void testMethodName() {
		assertEquals("testMethodName", ReflectionHelper.methodName());
	}
}
