package helper.json.type.container;

import java.util.*;
import java.util.Map.*;
import java.util.function.*;
import java.util.stream.*;

import helper.json.*;
import helper.json.type.*;

public final class JsonObject implements JsonContainer<Entry<String, JsonElement>> {

	private final Map<String, JsonElement> fields = new HashMap<>();
	
	public JsonObject() {}

	public JsonObject(String key, Object val) {
		add(key, val);
	}

	public JsonObject(String key, Object... vals) {
		add(key, vals);
	}
	
	public JsonObject(String key, Iterable<?> iter) {
		add(key, iter);
	}
	
	public JsonObject(String key, Function<JsonObject, JsonObject> jObj) {
		add(key, jObj);
	}
	
	@Override
	public boolean equals(Object obj) {
		Map<String, JsonElement> foreign = null;
		if (obj instanceof JsonObject jObj)
			foreign = jObj.fields;
		if (JsonHelper.toJson(obj) instanceof JsonObject jObj)
			foreign = jObj.fields;
		return foreign != null && fields.equals(foreign);
	}

	@Override
	public int hashCode() {
		return fields.hashCode();
	}

	public JsonObject add(String key, Object val) {
		fields.put(Objects.requireNonNull(key), JsonHelper.toJson(val));
		return this;
	}
	
	public JsonObject add(String key, Object... vals) {
		fields.put(Objects.requireNonNull(key), new JsonList(vals));
		return this;
	}
	
	public JsonObject add(String key, Iterable<?> iter) {
		fields.put(Objects.requireNonNull(key), JsonHelper.toJson(iter));
		return this;
	}
	
	public JsonObject add(String key, Function<JsonObject, JsonObject> jObj) {
		fields.put(key, jObj.apply(new JsonObject()));
		return this;
	}

	@Override
	public boolean isEmpty() { return fields.isEmpty(); }
	
	@Override
	public int size() {
		return fields.size();
	}
	
	@Override
	public Iterator<Entry<String, JsonElement>> iterator() {
		return toSet().iterator();
	}
	
	public Set<Entry<String, JsonElement>> toSet() {
		return fields.entrySet();
	}

	public Map<String, JsonElement> toMap() {
		return new HashMap<>(fields);
	}
	
	/** Single line print. */
	@Override
	public String toString() {
		return stream().map(e -> "\"" + e.getKey() + "\": " + e.getValue()) //
				.collect(Collectors.joining(", ", "{", "}"));
	}
}
