package helper.json.type.primitive;

public final class JsonNull implements JsonPrimitive {
	
	public static final JsonNull INSTANCE = new JsonNull();
	
	private JsonNull() {}
	
	// Object

	@Override
	public boolean equals(Object obj) {
		return obj == null || obj == INSTANCE;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	// toString
	
	@Override
	public String toString() {
		return "null";
	}
	
}
