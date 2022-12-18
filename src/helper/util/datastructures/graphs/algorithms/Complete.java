package helper.util.datastructures.graphs.algorithms;

import helper.util.datastructures.graphs.abstractions.GraphAlgorithm;
import helper.util.datastructures.graphs.implementations.graph.Graph;
import helper.util.datastructures.graphs.implementations.node.Node;

public record Complete
		<N extends Node<N, ?, ?>>
		(Graph<?, N, ?> graph)
		implements GraphAlgorithm<Boolean> {

	@Override
	public Boolean solve() {
		return graph.nodeCount() == graph.edgeCount() + 1;
	}
}
