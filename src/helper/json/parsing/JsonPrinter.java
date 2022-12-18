package helper.json.parsing;

import helper.json.type.JsonElement;
import helper.json.type.container.JsonContainer;
import helper.json.type.container.JsonList;
import helper.json.type.container.JsonObject;
import helper.util.ListHelper;
import helper.util.functions.QuadFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JsonPrinter {

	public static JsonPrintMode defaultPrintMode = JsonPrintMode.PRETTY;

	public enum JsonPrintMode {
		/** Everything in a single line. */
		SINGLE_LINE,
		/** Only spreads out the fields of an object if more than two exist . */
		PRETTY,
		/** Every field in a {@link JsonObject} and every {@link JsonList}-Entry has its own line. */
		SPREAD;
	}

	public static void main(String[] args) {
		System.out.println(toJsonString(JsonPrintMode.PRETTY, new JsonObject() //
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
				)));
	}

	public static String toJsonString(JsonPrintMode printMode, JsonContainer<?> jsonContainer) {
		return containerSwitch(jsonContainer, printMode, switch (printMode) {
			case SINGLE_LINE -> JsonPrinter::containerSingle;
			case PRETTY -> JsonPrinter::containerPretty;
			case SPREAD -> JsonPrinter::containerSpread;
		}).stream().collect(Collectors.joining("\n"));
	}

	@SuppressWarnings("unchecked")
	private static <T> List<String> containerSwitch(JsonContainer<T> jsonCon, JsonPrintMode printMode,
	                                                QuadFunction<String, String, Function<T, String>, JsonContainer<T>, List<String>> printerFunc) {
		return switch (jsonCon) {
			case JsonList jLst -> printerFunc.apply("[", "]", Object::toString, jsonCon);
			case JsonObject jObj -> printerFunc.apply("{", "}", e -> {
				var entry = (Entry<String, JsonElement>) e;
				return "\"" + entry.getKey() + "\": " + entry.getValue().toJsonString(printMode);
			}, jsonCon);
		};
	}

	private static <T> List<String> containerSingle(String open, String close, Function<T, String> primMap, JsonContainer<T> jsonCon) {
		return List.of(jsonCon.stream().map(primMap).collect(Collectors.joining(", ", open, close)));
	}

	private static <T> List<String> containerPretty(String open, String close, Function<T, String> primMap, JsonContainer<T> jsonCon) {
		List<String> lines = new ArrayList<>();
		if (jsonCon.isEmpty())
			return List.of(open + close);
		lines.add(open);
		int i = 0;
		for (T elem : jsonCon) {
			var jElem = elem instanceof Entry<?, ?> e ? e.getValue() : elem;
			if (jElem instanceof JsonContainer<?> jCon) {
				// if (jCon.size() == 1)
				// lines.add(jCon.toString());
				// else {
				List<String> inner = containerSwitch(jCon, JsonPrintMode.PRETTY, JsonPrinter::containerPretty);
				for (var innerElem : inner)
					lines.add("\t" + innerElem);
				// }
			} else
				lines.add("\t" + primMap.apply(elem));
			if (i++ < jsonCon.size() - 1)
				ListHelper.map(lines, lines.size() - 1, e -> e + ",");
		}
		lines.add(close);
		return lines;
	}

	private static <T> List<String> containerSpread(String open, String close, Function<T, String> primMap, JsonContainer<T> jsonCon) {
		List<String> lines = new ArrayList<>();
		if (jsonCon.isEmpty())
			return List.of(open + close);
		lines.add(open);
		int i = 0;
		for (T elem : jsonCon) {
			var jElem = elem instanceof Entry<?, ?> e ? e.getValue() : elem;
			if (jElem instanceof JsonContainer<?> jCon) {
				List<String> inner = containerSwitch(jCon, JsonPrintMode.SPREAD, JsonPrinter::containerSpread);
				for (var innerElem : inner)
					lines.add("\t" + innerElem);
			} else
				lines.add("\t" + primMap.apply(elem));
			if (i++ < jsonCon.size() - 1)
				ListHelper.map(lines, lines.size() - 1, e -> e + ",");
		}
		lines.add(close);
		return lines;
	}
}
