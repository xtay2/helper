package helper.util.datastructures.graphs.implementations.graph;

import helper.util.datastructures.graphs.implementations.edge.WeightedEdge;
import helper.util.datastructures.graphs.implementations.node.Node;

public class WeightedGraph<
		V extends Comparable<V>,
		N extends Node<N, V, E>,
		E extends WeightedEdge<E, V, N>
		> extends Graph<V, N, E> {

	@Override
	public final boolean isWeighted() {
		return true;
	}
}

