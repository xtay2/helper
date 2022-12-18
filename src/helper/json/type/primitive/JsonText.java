package helper.json.type.primitive;

import java.util.*;

public final class JsonText implements JsonPrimitive, CharSequence, Comparable<CharSequence>, Iterable<Character> {
	
	private final CharSequence val;
	
	public JsonText(Character val) {
		this(String.valueOf(Objects.requireNonNull(val)));
	}

	public JsonText(CharSequence val) {
		this.val = Objects.requireNonNull(val);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof CharSequence c //
				&& length() == c.length() //
				&& CharSequence.compare(this, c) == 0;
	}

	@Override
	public int hashCode() {
		return val.hashCode();
	}

	// CharSequence
	
	@Override
	public int length() {
		return val.length();
	}

	@Override
	public char charAt(int index) {
		return val.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return val.subSequence(start, end);
	}
	
	// Comparable
	
	@Override
	public int compareTo(CharSequence o) {
		return CharSequence.compare(val, o);
	}

	// Iterable

	@Override
	public Iterator<Character> iterator() {
		return new Iterator<>() {

			private int cur = 0;
			
			@Override
			public boolean hasNext() {
				return cur < length();
			}

			@Override
			public Character next() {
				if (hasNext())
					return charAt(cur++);
				throw new NoSuchElementException();
			}
		};
	}
	
	// Value-Methods
	
	public char charValue() {
		if (val.length() != 1)
			throw new IllegalStateException("This JsonText has a length of " + val.length() + " and cannot get interpreted as one char.");
		return val.charAt(0);
	}
	
	public char[] charArrayValue() {
		return stringValue().toCharArray();
	}

	public String stringValue() {
		return val.toString();
	}
	
	public StringBuilder stringBuilderValue() {
		return new StringBuilder(val);
	}
	
	// toString
	
	@Override
	public String toString() {
		return "\"" + val + "\"";
	}
}
