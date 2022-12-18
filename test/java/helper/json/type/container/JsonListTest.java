package helper.json.type.container;

import helper.json.type.JsonElement;
import helper.json.type.JsonElementTest;

public class JsonListTest implements JsonElementTest {

	private final JsonElement mock = new JsonObject() //
			.add("list1", new JsonList())
			.add("list2", 1, 2, 3)
			.add("list3", 1, new JsonList(1, 2, 3), 3)

			.add("obj1", new JsonObject())
			.add("obj2", new JsonObject("field", "String"))
			.add("obj3", new JsonObject()
					.add("field1", "Some text")
					.add("field2", "Some other text"))
			.add("obj4", new JsonObject()
					.add("field1", "Some text")
					.add("field2", 1, 2, 3)
					.add("field3", new JsonObject("field3", 10))
					.add("field4", new JsonObject()
							.add("field1", "Some text")
							.add("field2", "Some other text")) //
			);

	public void containsTest() {
		assertTrue(new JsonList(1, 2, 3).contains(1));
		assertTrue(new JsonList(1, 2, 3).contains(new JsonNr(1)));
		assertFalse(new JsonList(1, 2, 3).contains("Hello"));
		assertFalse(new JsonList(1, 2, 3).contains(new JsonText("Hello")));
	}

	@Override
	@Test
	public void toSingleStringTest() {
		assertEquals("[]", new JsonList().toJsonString(JsonPrintMode.SINGLE_LINE));
		assertEquals("{\"list1\": [], \"list3\": [1, [1, 2, 3], 3], \"list2\": [1, 2, 3], \"obj2\": {\"field\": \"String\"}, \"obj1\": {},"
				+ " \"obj4\": {\"field1\": \"Some text\", \"field3\": {\"field3\": 10}, \"field2\": [1, 2, 3],"
				+ " \"field4\": {\"field1\": \"Some text\", \"field2\": \"Some other text\"}},"
				+ " \"obj3\": {\"field1\": \"Some text\", \"field2\": \"Some other text\"}}\r\n"
				+ "", mock.toJsonString(JsonPrintMode.SINGLE_LINE));
	}

	@Override
	@Test
	public void toPrettyStringTest() {
		assertEquals("[]", new JsonList().toJsonString(JsonPrintMode.PRETTY));
		assertEquals("""
				{
						{
					    "list1": [],
					    "list2": [1, 2, 3],
					    "list3": [
					        1,
					        [1,2, 3],
					        3
					    ],
					    "obj1": {},
					    "obj2": { "field": "String" },
					    "obj3": {
					        "field1": "Some text",
					        "field2": "Some other text"
					    },
					    "obj4": {
					        "field1": "Some text",
					        "field2": [1, 2, 3]
					        "field3": { "field": 10 },
					        "field4": {
					            "field1": "Some text",
					            "field2": "Some other text"
					        },
					    },
					}
				}""", mock.toJsonString(JsonPrintMode.PRETTY));
	}

	@Override
	@Test
	public void toSpreadStringTest() {
		assertEquals("[]", new JsonList().toJsonString(JsonPrintMode.SPREAD));
		assertEquals("""
				{
					[],
					[
						1,
						[
							1,
							2,
							3
						],
						3
					],
					[
						1,
						2,
						3
					],
					{
						"field": "String"
					},
					{},
					{
						"field1": "Some text",
						{
							"field3": 10
						},
						[
							1,
							2,
							3
						],
						{
							"field1": "Some text",
							"field2": "Some other text"
						}
					},
					{
						"field1": "Some text",
						"field2": "Some other text"
					}
				}""", mock.toJsonString(JsonPrintMode.SPREAD));
	}

}
