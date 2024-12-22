package helper.base;

import java.util.List;
import java.util.Objects;

import static java.lang.Math.min;

@SuppressWarnings("unused")
public class StringHelper {

	/**
	 * Converts a {@link CharSequence} to a {@link char[]}
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
		if (part.length() == 0)
			return 0;
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
		return occAfter(c, 0, whole);
	}

	/**
	 * Returns the amount of occurences of chars at the end of a {@link CharSequence}.
	 */
	public static int occAtEnd(char c, CharSequence whole) {
		return occBefore(c, whole.length() - 1, whole);
	}

	/**
	 * Returns the amount of occurences of chars after (inklusive) a certain index in a {@link CharSequence}.
	 */
	public static int occAfter(char c, int idx, CharSequence whole) {
		int occ = 0;
		for (int i = idx; i < whole.length(); i++) {
			if (whole.charAt(i) == c)
				occ++;
			else
				break;
		}
		return occ;
	}

	/**
	 * Returns the amount of occurences of chars before (inklusive) a certain index in a {@link CharSequence}.
	 */
	public static int occBefore(char c, int idx, CharSequence whole) {
		int occ = 0;
		for (int i = idx; i >= 0; i--) {
			if (whole.charAt(i) == c)
				occ++;
			else
				break;
		}
		return occ;
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
	 * Removes the passed char from the start of the passed sequence.
	 */
	public static String removeLeading(String s, char prefix) {
		return s.substring(occAtStart(prefix, s));
	}

	/**
	 * Removes the passed char from the end of the passed sequence.
	 */
	public static String removeTrailing(String s, char suffix) {
		return s.substring(0, s.length() - occAtEnd(suffix, s));
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

	/**
	 * Returns the longest common prefix of two {@link CharSequence}s.
	 */
	public static CharSequence commonPrefix(CharSequence a, CharSequence b) {
		int i = 0;
		while (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i))
			i++;
		return a.subSequence(0, i);
	}

	/** Returns the amount of whitespaces after (exclusive) an index. */
	public static int spacesAfter(CharSequence chars, int idx) {
		for (int i = idx; i < chars.length(); i++) {
			if (!Character.isWhitespace(chars.charAt(i)))
				return i - idx;
		}
		return chars.length() - idx;
	}

	/** Returns the amount of whitespaces before (exclusive) an index. */
	public static int spacesBefore(CharSequence chars, int idx) {
		for (int i = idx - 1; i >= 0; i--) {
			if (!Character.isWhitespace(chars.charAt(i)))
				return idx - i - 1;
		}
		return idx;
	}

	public static int leadingSpaces(CharSequence chars) {
		return spacesAfter(chars, 0);
	}

	public static int trailingSpaces(CharSequence chars) {
		return spacesBefore(chars, chars.length());
	}

	public static List<String> findAll(String numbersRegex, String line) {
		return null; // TODO: Implement me!
	}
}