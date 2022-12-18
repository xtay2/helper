package helper.json.type.primitive;

public final class JsonBool implements JsonPrimitive, Comparable<JsonBool> {
	
	public static final JsonBool TRUE = new JsonBool(true), FALSE = new JsonBool(false);
	
	private final boolean val;

	private JsonBool(boolean val) {
		this.val = val;
	}

	public static JsonBool instance(boolean val) {
		return val ? TRUE : FALSE;
	}
	
	// Object

	@Override
	public boolean equals(Object obj) {
		return obj == this;
	}

	@Override
	public int hashCode() {
		return Boolean.hashCode(val);
	}

	// Comparable
	
	@Override
	public int compareTo(JsonBool o) {
		return Boolean.compare(val, o.val);
	}

	// toString
	
	@Override
	public String toString() {
		return String.valueOf(val);
	}

}
