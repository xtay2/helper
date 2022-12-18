package helper.json;

import helper.base.ClassHelper;
import helper.json.parsing.JsonPrinter;
import helper.json.parsing.JsonPrinter.JsonPrintMode;
import helper.json.parsing.JsonTree;
import helper.json.type.JsonElement;
import helper.json.type.container.JsonList;
import helper.json.type.container.JsonObject;
import helper.json.type.primitive.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JsonHelper {

	public static void setPrintMode(JsonPrintMode printMode) {JsonPrinter.defaultPrintMode = Objects.requireNonNull(printMode);}

	/**
	 * Turns any object into a {@link JsonElement}.
	 *
	 * <pre>
	 * - Any {@link JsonElement} is returned unchanged.
	 * - {@code null}-values get turned into {@link JsonNull}.
	 * - {@link Boolean}, {@link CharSequence}, {@link Number} -> {@link JsonPrimitive}
	 * -
	 * </pre>
	 *
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("preview")
	public static JsonElement toJson(Object obj) {
		if (obj == null)
			return JsonNull.INSTANCE;
		if (obj.getClass().isArray())
			return new JsonList((Object[]) obj);
		return switch (obj) {
			case JsonElement j -> j;
			case Boolean b -> JsonBool.instance(b);
			case Character c -> new JsonText(c);
			case CharSequence c -> new JsonText(c);
			case Number n -> new JsonNr(n);
			case Iterable<?> i -> new JsonList(i);
			default -> {
				JsonObject res = new JsonObject();
				for (Field f : ClassHelper.allFieldsOf(obj.getClass()))
					if (!f.isSynthetic() && !Modifier.isTransient(f.getModifiers()))
						res.add(f.getName(), toJson(obj));
				yield res;
			}
		};
	}

	public static <T> T parse(String jStr, Class<T> cls) {
		return fromJson(parse(jStr), cls);
	}

	@SuppressWarnings("unchecked")
	public static <T> T fromJson(JsonElement jElem, Class<T> cls) {
		if (cls.isAssignableFrom(jElem.getClass()))
			return (T) jElem;
		if (JsonElement.class.isAssignableFrom(cls))
			throw new IllegalArgumentException("Cannot convert between different JsonElements.");
		if (cls.isInterface() || Modifier.isAbstract(cls.getModifiers()))
			return allowedInterfaces(jElem, cls);
		return JsonTree.fromJson(jElem, cls);
	}

	/**
	 * The only two allowed interfaces/abstract-classes that aren't assignable from the respective
	 * {@link JsonElement} are {@link List} for {@link JsonList} and {@link Map} for {@link JsonObject}.
	 */
	@SuppressWarnings({"unchecked"})
	private static <T> T allowedInterfaces(JsonElement jElem, Class<T> cls) {
		return switch (jElem) {
			case JsonList jList when List.class.isAssignableFrom(cls) -> (T) jList.toList();
			case JsonObject jObj when Map.class.isAssignableFrom(cls) -> (T) jObj.toMap();
			default -> throw new IllegalArgumentException("Please provide a non-abstract class. Was: " + cls);
		};
	}

	public static JsonElement parse(String jStr) {
		return null;
	}

}
