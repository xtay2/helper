package helper.util.datastructures.graphs.implementations.path;

import helper.util.datastructures.graphs.implementations.edge.Edge;
import helper.util.datastructures.graphs.implementations.graph.Graph;
import helper.util.datastructures.graphs.implementations.node.Node;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Mutable data structure for paths.
 *
 * @param <N> Nodes in this path.
 * @param <E> Edges in this path.
 */
@SuppressWarnings("unused")
public final class Path<
		V,
		N extends Node<N, V, E>,
		E extends Edge<N>
		> extends Graph<V, N, E> implements Iterable<N> {

	private N startNode = null, endNode = null;

	public Path() {
		super();
	}

	public Path(N... nodes) {
		Arrays.stream(nodes).forEach(this::append);
	}

	public Path(Iterable<N> nodes) {
		nodes.forEach(this::append);
	}

	@Override
	public Iterator<N> iterator() {
		return nodes().iterator();
	}

	public N startNode() {
		return startNode;
	}

	public N endNode() {
		return endNode;
	}

	public boolean prepend(N node) {
		if (contains(node))
			return false;
		addEdge(node, startNode);
		startNode = node;
		return true;
	}

	public boolean append(N node) {
		if (contains(node))
			return false;
		addEdge(endNode, node);
		endNode = node;
		return true;
	}

	@Override
	public boolean hasCycle() {
		return false;
	}

	@Override
	public boolean hasNegativeCycle() {
		return false;
	}

	@Override
	public boolean isPath() {
		return true;
	}

	@Override
	public boolean isTree() {
		return true;
	}

	@Override
	public boolean isCycle() {
		return false;
	}

	@Override
	public boolean isConnected() {
		return true;
	}

	@Override
	public boolean isDirected() {
		return true;
	}

	@Override
	public boolean isComplete() {
		return isEmpty();
	}
}
