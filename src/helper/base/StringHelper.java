package helper.base;

import java.util.Objects;

import static java.lang.Math.min;

@SuppressWarnings("unused")
public class StringHelper {

	/**
	 * Converts a {@link CharSequence} to a {@link Character[]}
	 */
	public static Character[] charArray(CharSequence str) {
		return str.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
	}

	/**
	 * Returns the amount of occurences of a {@link Character} in a {@link CharSequence}.
	 */
	public static int occ(char part, CharSequence whole) {
		return occ(String.valueOf(part), whole);
	}

	/**
	 * Returns the amount of occurences of a {@link CharSequence} in another one.
	 */
	public static int occ(CharSequence part, CharSequence whole) {
		int cnt = 0;
		for (int i = 0; i <= whole.length() - part.length(); i++) {
			if (Objects.equals(whole.subSequence(i, i + part.length()), part))
				cnt++;
		}
		return cnt;
	}

	/**
	 * Returns the amount of occurences of chars at the start of a {@link CharSequence}.
	 */
	public static int occAtStart(char c, CharSequence whole) {
		return (int) whole.chars().takeWhile(ch -> ch == c).count();
	}

	/**
	 * Removes all passed chars from the passed sequence.
	 */
	public static String remove(CharSequence s, char... chars) {
		for (char c : chars)
			s = s.toString().replace(String.valueOf(c), "");
		return (String) s;
	}

	/**
	 * Appends a {@link Character} to a {@link CharSequence}.
	 */
	public static CharSequence append(CharSequence a, Character b) {
		StringBuilder sb = new StringBuilder();
		if (a != null)
			sb.append(a);
		if (b != null)
			sb.append(b);
		return sb;
	}

	/**
	 * Checks if the snippet starts with the prefix, but the prefix can be greater than the snippet.
	 */
	public static boolean startsWith(CharSequence snippet, CharSequence prefix) {
		if (snippet.isEmpty())
			return true;
		var p = prefix.toString();
		return snippet.toString().startsWith(p.substring(0, min(snippet.length(), p.length())));
	}

}
