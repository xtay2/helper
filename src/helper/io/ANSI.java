package helper.io;

/**
 * Helper for ANSI-console-coloring of Strings.
 */
@SuppressWarnings("unused")
public enum ANSI {

	ESCAPE("\u001B"),
	RESET(ESCAPE + "[0m"),
	BLACK(ESCAPE + "[30m"),
	RED(ESCAPE + "[31m"),
	GREEN(ESCAPE + "[32m"),
	YELLOW(ESCAPE + "[33m"),
	BLUE(ESCAPE + "[34m"),
	PURPLE(ESCAPE + "[35m"),
	CYAN(ESCAPE + "[36m");

	private final String code;

	ANSI(String code) {
		this.code = code;
	}

	public static String color(ANSI color, String text) {
		return color + text + RESET;
	}

	@Override
	public String toString() {
		return code;
	}
}
