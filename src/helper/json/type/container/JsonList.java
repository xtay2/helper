package helper.json.type.container;

import java.util.*;
import java.util.function.*;

import helper.json.*;
import helper.json.parsing.JsonPrinter.*;
import helper.json.type.*;

public final class JsonList implements JsonContainer<JsonElement>, RandomAccess {
	
	private final List<JsonElement> content;
	
	/** Creates an empty {@link JsonList} */
	public JsonList() {
		content = new ArrayList<>();
	}
	
	/** @see ArrayList#ArrayList(int) */
	public JsonList(int initialCapacity) {
		content = new ArrayList<>(initialCapacity);
	}
	
	/** Creates a {@link JsonList} based on the elements in the passed array. */
	@SafeVarargs
	public JsonList(Object... vals) {
		this(vals.length);
		add(vals);
	}
	
	/** Creates a {@link JsonList} based on the elements in the passed {@link Iterable}. */
	public JsonList(Iterable<?> iter) {
		this();
		add(iter);
	}
	
	// Add / Insert
	
	/** @see Collection#add(Object) */
	public JsonList add(Object val) {
		content.add(val instanceof JsonElement jElem ? jElem : JsonHelper.toJson(val));
		return this;
	}

	@SafeVarargs
	/** @see Collection#addAll(Collection) */
	public final JsonList add(Object... vals) {
		for (var e : vals)
			add(e);
		return this;
	}
	
	/** @see Collection#addAll(Collection) */
	public JsonList add(Iterable<?> iter) {
		if (iter instanceof JsonContainer)
			return add((Object) iter);
		for (var e : iter)
			add(e);
		return this;
	}

	/** @see Collection#add(Object) */
	public JsonList add(Function<JsonObject, JsonObject> jObj) {
		content.add(jObj.apply(new JsonObject()));
		return this;
	}
	
	/** @see List#add(int, Object) */
	public JsonList insert(int idx, Object val) {
		content.add(idx, JsonHelper.toJson(val));
		return this;
	}
	
	@SafeVarargs
	/** @see List#add(int, Object) */
	public final JsonList insert(int idx, Object... vals) {
		for (var e : vals)
			insert(idx++, e);
		return this;
	}
	
	/** @see List#addAll(int, Collection) */
	public JsonList insert(int idx, Iterable<?> iter) {
		for (var e : iter)
			insert(idx++, e);
		return this;
	}

	// Remove
	
	/** @see Collection#remove(Object) */
	public JsonElement remove(int idx) {
		return content.remove(idx);
	}
	
	/** @see Collection#removeIf(Predicate) */
	public boolean removeIf(Predicate<JsonElement> predicate) {
		return content.removeIf(predicate);
	}
	
	// Lookup

	/** @see List#get(int) */
	public JsonElement get(int idx) {
		return content.get(idx);
	}

	/** @see Collection#contains(Object) */
	public boolean contains(Object elem) {
		return elem != null && content.contains(elem);
	}

	/** @see List#indexOf(Object) */
	public int indexOf(Object elem) {
		return content.indexOf(elem);
	}

	/** @see List#lastIndexOf(Object) */
	public int lastIndexOf(Object elem) {
		return content.lastIndexOf(elem);
	}

	/** @see Collection#size() */
	@Override
	public int size() {
		return content.size();
	}
	
	/** @see Collection#isEmpty() */
	@Override
	public boolean isEmpty() { return content.isEmpty(); }

	// Visit all

	/** @see Collection#toArray() */
	public JsonElement[] toArray() {
		return content.toArray(new JsonElement[size()]);
	}
	
	@Override
	public ListIterator<JsonElement> iterator() {
		return content.listIterator();
	}
	
	/** Converts this into a {@link List}-Implementation. */
	public List<JsonElement> toList() {
		return new ArrayList<>(content);
	}
	
	/** @see List#subList(int, int) */
	public List<JsonElement> subList(int fromIndex, int toIndex) {
		return content.subList(fromIndex, toIndex);
	}
	
	// toString

	/** @see JsonObject#toJsonString() */
	@Override
	public String toString() {
		return toJsonString(JsonPrintMode.SINGLE_LINE);
	}
}
