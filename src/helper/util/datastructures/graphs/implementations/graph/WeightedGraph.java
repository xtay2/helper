package helper.util.datastructures.graphs.implementations.graph;

import helper.util.datastructures.graphs.implementations.edge.WeightedEdge;
import helper.util.datastructures.graphs.implementations.node.Node;
import helper.util.datastructures.graphs.implementations.path.Path;

public class WeightedGraph<
		V extends Comparable<V>,
		N extends Node<N, V, E>,
		E extends WeightedEdge<E, V, N>
		> extends Graph<V, N, E> {

	public final boolean addNode(N node) {
		return super.addNode(node);
	}

	public final boolean addEdge(N node1, N node2) {
		return super.addEdge(node1, node2);
	}

	public final boolean addEdge(E edge) {
		return super.addEdge(edge);
	}

	public final void addEdges(E... edges) {
		super.addEdges(edges);
	}

	public final void addEdges(Iterable<E> edges) {
		super.addEdges(edges);
	}

	@Override
	public final boolean isWeighted() {
		return true;
	}

	public Path<V, N, E> shortestPath(N start, N end) {
		// TODO: Implement me!
		return null;
	}

	public Path<V, N, E> longestPath(N start, N end) {
		// TODO: Implement me!
		return null;
	}
}

