package helper.misc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Optional;

public class UnsafeHelper {

	@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
	private static Optional<Unsafe> UNSAVE_SINGLETON;

	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			UNSAVE_SINGLETON = Optional.of((Unsafe) f.get(null));
		} catch (Exception e) {
			UNSAVE_SINGLETON = Optional.empty();
		}
	}

	public static Optional<Unsafe> instance() {
		return UNSAVE_SINGLETON;
	}
}
