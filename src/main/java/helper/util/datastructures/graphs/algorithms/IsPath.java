package helper.util.datastructures.graphs.algorithms;

import helper.util.datastructures.graphs.abstractions.GraphAlgorithm;
import helper.util.datastructures.graphs.implementations.graph.Graph;
import helper.util.datastructures.graphs.implementations.node.Node;

import static helper.util.SetHelper.getAny;

public record IsPath
		<N extends Node<N, ?, ?>>
		(Graph<?, N, ?> graph)
		implements GraphAlgorithm<Boolean> {

	@Override
	public Boolean solve() {
		var start = getAny(graph.nodes());
		int visited = 0;
		while (graph.neighbours(start).size() == 1) {
			start = getAny(graph.neighbours(start));
			visited++;
		}
		return graph.neighbours(start).isEmpty() && visited == graph.nodeCount() - 1;
	}

}
