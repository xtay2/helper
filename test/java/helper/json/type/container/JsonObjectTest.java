package helper.json.type.container;

import helper.json.type.JsonElementTest;
import org.junit.jupiter.api.Test;

public class JsonObjectTest implements JsonElementTest {

	@Test
	public void toStringTest() {
		// TODO Implement me!
	}

	@Override
	public void toSingleStringTest() {

	}

	@Override
	@Test
	public void toPrettyStringTest() {
		System.out.println(new JsonObject() //
				.add("number", 5) //
				.add("text", "String") //
				.add("obj", new JsonObject()) //
				.add("array", 1, 2, 3, new JsonObject()) //
				.add("subObj", //
						obj -> obj.add("list", new JsonList()) //
				).toJsonString());
	}

	@Override
	public void toSpreadStringTest() {

	}

}
