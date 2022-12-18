package helper.util.datastructures.graphs.algorithms;

import helper.util.SetHelper;
import helper.util.datastructures.graphs.abstractions.GraphAlgorithm;
import helper.util.datastructures.graphs.implementations.graph.Graph;
import helper.util.datastructures.graphs.implementations.node.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * A version of @{@link DepthFirstSearch} that determines whether a graph has cycles.
 */
@SuppressWarnings("unused")
public record HasCycles
		<N extends Node<N, ?, ?>>
		(Graph<?, N, ?> graph)
		implements GraphAlgorithm<Boolean> {

	private boolean rec(N node, Set<N> visited) {
		if (visited.contains(node))
			return true;
		visited.add(node);
		for (var neighbour : graph.neighbours(node)) {
			if (rec(neighbour, visited))
				return true;
		}
		return false;
	}

	@Override
	public Boolean solve() {
		return rec(SetHelper.getAny(graph.nodes()), new HashSet<>());
	}

}
