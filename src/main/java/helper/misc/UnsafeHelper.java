package helper.misc;

import java.lang.reflect.*;
import java.util.*;

public class UnsafeHelper {
	
	private static Optional<sun.misc.Unsafe> UNSAVE_SINGLETON;
	
	static {
		try {
			Field f = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			UNSAVE_SINGLETON = Optional.of((sun.misc.Unsafe) f.get(null));
		} catch (@SuppressWarnings("unused") Exception e) {
			UNSAVE_SINGLETON = Optional.empty();
		}
	}
	
	public static Optional<sun.misc.Unsafe> instance() {
		return UNSAVE_SINGLETON;
	}
}
