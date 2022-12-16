package helper.util.datastructures.graphs.abstractions;

/**
 * Performs some calculation on a graph without modifying it.
 *
 * @param <R> The return type of the calculation. Should be set by the implementing class.
 */
public interface GraphAlgorithm<R> {
	R solve();
}
