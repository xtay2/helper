package helper.util.datastructures.graphs.algorithms;

import helper.util.SetHelper;
import helper.util.datastructures.graphs.abstractions.GraphAlgorithm;
import helper.util.datastructures.graphs.implementations.graph.Graph;
import helper.util.datastructures.graphs.implementations.node.Node;

public record IsPath
		<N extends Node<N, ?, ?>>
		(Graph<?, N, ?> graph)
		implements GraphAlgorithm<Boolean> {

	@Override
	public Boolean solve() {
		var start = SetHelper.getAny(graph.nodes());
		int visited = 0;
		while (graph.neighbours(start).size() == 1) {
			start = SetHelper.getAny(graph.neighbours(start));
			visited++;
		}
		return graph.neighbours(start).isEmpty() && visited == graph.nodeCount() - 1;
	}

}
