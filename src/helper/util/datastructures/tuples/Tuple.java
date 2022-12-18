package helper.util.datastructures.tuples;

import helper.util.annotations.DataStructure;

import java.util.Objects;
import java.util.function.Function;

@SuppressWarnings("unused")
@DataStructure(mutable = false, threadSafe = true, lazy = false, fixedSize = true, fixedType = false)
public class Tuple<A, B> {

	public final A x;
	public final B y;

	public Tuple(A a, B b) {
		this.x = a;
		this.y = b;
	}

	public <R1, R2> Tuple<R1, R2> map(Function<A, R1> mapX, Function<B, R2> mapY) {
		return new Tuple<>(mapX.apply(x), mapY.apply(y));
	}

	public <R> Tuple<R, B> mapX(Function<A, R> mapX) {
		return new Tuple<>(mapX.apply(x), y);
	}

	public <R> Tuple<A, R> mapY(Function<B, R> mapY) {
		return new Tuple<>(x, mapY.apply(y));
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Tuple && ((Tuple<?, ?>) obj).x.equals(x) && ((Tuple<?, ?>) obj).y.equals(y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public String toString() {
		return "(" + x.getClass().getSimpleName() + x + ", " + x.getClass().getSimpleName() + y + ")";
	}
}
