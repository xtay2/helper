package helper.json.type.container;

import helper.json.parsing.JsonPrinter;
import helper.json.type.JsonElement;
import helper.util.IteratorHelper;

import java.util.Collection;
import java.util.stream.Stream;

public sealed interface JsonContainer<T> extends Iterable<T>, JsonElement permits JsonList, JsonObject {

	boolean isEmpty();

	int size();

	default Stream<T> stream() {
		return IteratorHelper.stream(iterator());
	}

	/** @see Collection#stream() */
	@Override
	default String toJsonString() {
		return toJsonString(JsonPrinter.defaultPrintMode);
	}
}
