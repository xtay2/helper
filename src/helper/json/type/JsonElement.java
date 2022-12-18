package helper.json.type;

import helper.json.parsing.*;
import helper.json.parsing.JsonPrinter.*;
import helper.json.type.container.*;
import helper.json.type.primitive.*;

public interface JsonElement {

	// Container
	
	/**
	 * Quick cast to {@link JsonList}.
	 *
	 * @throws ClassCastException if the type doesn't match.
	 */
	default JsonList jLst() {
		return cast(JsonList.class);
	}
	
	/**
	 * Quick cast to {@link JsonObject}.
	 *
	 * @throws ClassCastException if the type doesn't match.
	 */
	default JsonObject jObj() {
		return cast(JsonObject.class);
	}
	
	// Primitives
	
	/**
	 * Quick cast to {@link JsonBool}.
	 *
	 * @throws ClassCastException if the type doesn't match.
	 */
	default JsonBool jBool() {
		return cast(JsonBool.class);
	}

	/**
	 * Quick cast to {@link JsonNr}.
	 *
	 * @throws ClassCastException if the type doesn't match.
	 */
	default JsonNr jNr() {
		return cast(JsonNr.class);
	}

	/**
	 * Quick cast to {@link JsonNull}.
	 *
	 * @throws ClassCastException if the type doesn't match.
	 */
	default JsonNull jNull() {
		return cast(JsonNull.class);
	}

	/**
	 * Quick cast to {@link JsonText}.
	 *
	 * @throws ClassCastException if the type doesn't match.
	 */
	default JsonText jTxt() {
		return cast(JsonText.class);
	}
	
	/**
	 * Quick cast to the passed class.
	 *
	 * @throws ClassCastException if the type doesn't match.
	 */
	private <T extends JsonElement> T cast(Class<T> to) {
		if (to.isInstance(this))
			return to.cast(this);
		throw new ClassCastException("Cannot cast this " + getClass().getSimpleName() + " to a " + to.getSimpleName() + ".");
	}

	/**
	 * Uses the {@link JsonPrinter#defaultPrintMode} to return a textual json representation of this.
	 */
	String toJsonString();

	default String toJsonString(JsonPrintMode printMode) {
		return this instanceof JsonContainer<?> c ? JsonPrinter.toJsonString(printMode, c) : toString();
	}

}
