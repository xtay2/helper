package helper.util.datastructures.graphs.implementations.edge;

import helper.util.datastructures.graphs.implementations.node.Node;
import helper.util.datastructures.tuples.Pair;

public class Edge<N extends Node> extends Pair<N> {

	public Edge(N x, N y) {
		super(x, y);
	}

	@SuppressWarnings("unchecked")
	public static <N extends Node, E extends Edge<N>> E connect(N node1, N node2) {
		return (E) new Edge<N>(node1, node2);
	}

}
