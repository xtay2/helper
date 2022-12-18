package helper.util.datastructures.graphs.algorithms;

import helper.util.SetHelper;
import helper.util.datastructures.graphs.abstractions.GraphAlgorithm;
import helper.util.datastructures.graphs.implementations.edge.WeightedEdge;
import helper.util.datastructures.graphs.implementations.graph.Graph;
import helper.util.datastructures.graphs.implementations.node.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * A version of @{@link DepthFirstSearch} that determines whether a graph has negative cycles.
 */
@SuppressWarnings("unused")
public record HasNegativeCycles
		<N extends Node<N, ?, ?>>
		(Graph<?, N, ?> graph)
		implements GraphAlgorithm<Boolean> {

	@SuppressWarnings("rawtypes")
	private boolean rec(N node, N last, Set<N> visited) {
		if (visited.contains(node) && graph.edge(node, last) instanceof WeightedEdge we && we.isNegative())
			return true;
		visited.add(node);
		for (var neighbour : graph.neighbours(node)) {
			if (rec(neighbour, node, visited))
				return true;
		}
		return false;
	}

	@Override
	public Boolean solve() {
		return rec(SetHelper.getAny(graph.nodes()), null, new HashSet<>());
	}

}
