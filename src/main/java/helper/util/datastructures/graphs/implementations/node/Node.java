package helper.util.datastructures.graphs.implementations.node;

import helper.util.annotations.DataStructure;
import helper.util.datastructures.graphs.implementations.edge.Edge;
import helper.util.datastructures.graphs.implementations.graph.Graph;

import java.util.Objects;

@DataStructure(mutable = false)
public class Node<
		S extends Node<S, V, E>, // Self
		V, // Value
		E extends Edge<S> // Edge
		> extends Graph<V, S, E> {
	public final V value;

	public Node(V value) {this.value = value;}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		return obj == this || obj instanceof Node n && Objects.equals(value, n.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "Node[" + value + ']';
	}

	@Override
	public final boolean isComplete() {
		return true;
	}

	@Override
	public final boolean isDirected() {
		return false;
	}

	@Override
	public final boolean isTree() {
		return true;
	}

	@Override
	public final boolean isWeighted() {
		return false;
	}

	@Override
	public final boolean isConnected() {
		return true;
	}

	@Override
	public final boolean isCycle() {
		return false;
	}

	@Override
	public final boolean isPath() {
		return true;
	}
}
