package helper.reflection;

import java.util.List;

/** {@link GenericHelper} */
public class GenericTest {

	public String nonGenericField;
	public List<String> genericField;

	@Test
	public void testGetGenericClass() throws Exception {
		assertEquals(0, GenericHelper.getGenericTypesOfField(GenericTest.class.getField("nonGenericField")).length);
		assertEquals(String.class, GenericHelper.getGenericTypesOfField(GenericTest.class.getField("genericField"))[0]);
	}

}
