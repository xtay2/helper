package helper.util.datastructures.graphs.algorithms;

import helper.util.datastructures.graphs.abstractions.GraphAlgorithm;
import helper.util.datastructures.graphs.implementations.graph.Graph;
import helper.util.datastructures.graphs.implementations.node.Node;

import java.util.ArrayList;
import java.util.List;

import static helper.util.SetHelper.getAny;

public record Connected
		<N extends Node<N, ?, ?>>
		(Graph<?, N, ?> graph)
		implements GraphAlgorithm<Boolean> {

	private int rec(N node, List<N> visited) {
		if (visited.contains(node))
			return visited.size();
		visited.add(node);
		for (var neighbour : graph.neighbours(node))
			rec(neighbour, visited);
		return visited.size();
	}

	@Override
	public Boolean solve() {
		return rec(getAny(graph.nodes()), new ArrayList<>(graph.nodeCount())) == graph.nodeCount();
	}
}
