module helper {
	requires jdk.unsupported;
	opens helper.base;
	exports helper.io;
	exports helper.base;
	exports helper.util;
}