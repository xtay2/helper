module helper {
	requires jdk.unsupported;
	opens helper.base;
	exports helper.io;
	exports helper.base;
	exports helper.util;
	exports helper.util.types;
	exports helper.util.functions;
}