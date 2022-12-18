package helper.util.annotations;

import java.lang.annotation.*;

@SuppressWarnings("unused")
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DataStructure {

	boolean mutable();

	boolean threadSafe();

	boolean lazy();

	boolean fixedSize();

	boolean fixedType();
}
