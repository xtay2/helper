package helper.util;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public class ArrayMatrixHelper {

	public static <T> T[][] fill(T[][] matrix, T value) {
		for (var line : matrix)
			Arrays.fill(line, value);
		return matrix;
	}

	public static <T> String toString(T[][] matrix, Function<T[], String> mapper) {
		var sb = new StringBuilder();
		for (var line : matrix)
			sb.append(mapper.apply(line)).append("\n");
		return sb.toString();
	}

	public static <T> String toString(T[][] matrix) {
		return toString(matrix, Arrays::toString);
	}

	public static <T> int matches(T[][] matrix, T match) {
		return matches(matrix, match::equals);
	}

	public static <T> int matches(T[][] matrix, Predicate<T> predicate) {
		int cnt = 0;
		for (var line : matrix) {
			for (var e : line) {
				if (predicate.test(e))
					cnt++;
			}
		}
		return cnt;
	}

	public static <T> T[][] copy(T[][] source, T[][] target, Predicate<T> predicate) {
		try {
			for (int i = 0; i < source.length; i++) {
				for (int j = 0; j < source[i].length; j++) {
					if (predicate.test(source[i][j]))
						target[i][j] = source[i][j];
				}
			}
		} catch (IndexOutOfBoundsException ioe) {
			throw new IllegalArgumentException("The passed matrices have to have equal dimensions.", ioe);
		}
		return target;
	}

}
