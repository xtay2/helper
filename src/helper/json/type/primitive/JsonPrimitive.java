package helper.json.type.primitive;

import helper.json.type.*;

public sealed interface JsonPrimitive extends JsonElement permits JsonBool, JsonNr, JsonNull, JsonText {
	
	@Override
	default String toJsonString() {
		return toString();
	}
}
