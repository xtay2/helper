package helper.util.datastructures.graphs.algorithms;

import helper.util.datastructures.graphs.abstractions.GraphAlgorithm;
import helper.util.datastructures.graphs.implementations.edge.Edge;
import helper.util.datastructures.graphs.implementations.graph.Graph;
import helper.util.datastructures.graphs.implementations.node.Node;
import helper.util.datastructures.graphs.implementations.path.Path;

public record DepthFirstSearch<
		V extends Comparable<V>,
		N extends Node<N, V, E>,
		E extends Edge<N>>
		(Graph<?, N, E> graph, N startNode, N endNode)
		implements GraphAlgorithm<Path<V, N, E>> {

	private Path<V, N, E> rec(N node, Path<V, N, E> path) {
		if (node.equals(endNode)) {
			path.append(node);
			return path;
		}
		for (var neighbour : graph.neighbours(node)) {
			if (!path.contains(neighbour)) {
				path = new Path<>(path);
				path.append(neighbour);
				rec(neighbour, path);
			}
		}
		return path;
	}

	@Override
	public Path<V, N, E> solve() {
		return rec(startNode, new Path<V, N, E>());
	}
}
