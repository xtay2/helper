package helper.reflection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

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
		assertNotEquals(null, val.get());
	}
	
	@Test
	public void testMethodName() {
		assertEquals("testMethodName", ReflectionHelper.methodName());
	}
}
