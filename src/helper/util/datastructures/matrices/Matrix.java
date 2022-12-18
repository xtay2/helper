package helper.util.datastructures.matrices;

import helper.util.annotations.DataStructure;
import helper.util.datastructures.graphs.implementations.edge.Edge;
import helper.util.datastructures.graphs.implementations.graph.Graph;
import helper.util.datastructures.graphs.implementations.node.Node;
import helper.util.datastructures.tuples.points.IntPoint;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Stream;

@DataStructure(mutable = true, threadSafe = false, lazy = false, fixedSize = true, fixedType = false)
@SuppressWarnings("unused")
public class Matrix<T> {

	// Construction

	public Matrix(int width, int height) {}

	public Matrix(int[][] intMatrix) {}

	public Matrix(long[][] intMatrix) {}

	public Matrix(T[][] intMatrix) {}

	public static Matrix<Character> fromString(String string) {
		// TODO: Implement me!
		return null;
	}

	// Access

	public T get(int x, int y) {
		// TODO: Implement me!
		return null;
	}

	public T get(IntPoint point) {
		// TODO: Implement me!
		return null;
	}

	public void set(int x, int y, T value) {
		// TODO: Implement me!
	}

	public void set(IntPoint point, T value) {
		// TODO: Implement me!
	}

	public int width() {
		// TODO: Implement me!
		return -1;
	}

	public int height() {
		// TODO: Implement me!
		return -1;
	}

	public T[] row(int col) {
		return row(col, 0, width());
	}

	public T[] row(int col, int start) {
		return row(col, start, width());
	}

	public T[] row(int col, int start, int end) {
		// TODO: Implement me!
		return null;
	}

	public T[] col(int row) {
		return col(row, 0, height());
	}

	public T[] col(int row, int start) {
		return col(row, start, height());
	}

	public T[] col(int row, int start, int end) {
		// TODO: Implement me!
		return null;
	}

	// Output

	public <R> Matrix<R> map(Function<T, R> mapper) {
		// TODO: Implement me!
		return null;
	}

	public <R> Matrix<R> map(BiFunction<Matrix<T>, IntPoint, R> mapper) {
		// TODO: Implement me!
		return null;
	}

	public <R> R reduce(R identity, BiFunction<R, T, R> mapper) {
		// TODO: Implement me!
		return null;
	}

	public <R> R[] reduceRows(R identity, BiFunction<R, T, R> mapper) {
		// TODO: Implement me!
		return null;
	}

	public <R> R[] reduceCols(R identity, BiFunction<R, T, R> mapper) {
		// TODO: Implement me!
		return null;
	}

	public Stream<T> filter(BiPredicate<Matrix<T>, IntPoint> predicate) {
		// TODO: Implement me!
		return null;
	}

	public <N extends Node<N, T, E>, E extends Edge<N>> Graph<T, N, E> toGraph() {
		// TODO: Implement me!
		return null;
	}

	public List<T> toList() {
		// TODO: Implement me!
		return null;
	}

	public Stream<T> toStream() {
		// TODO: Implement me!
		return null;
	}

	public T[][] toArrayMatrix() {
		// TODO: Implement me!
		return null;
	}

	@Override
	public String toString() {
		// TODO: Implement me!
		return null;
	}
}
