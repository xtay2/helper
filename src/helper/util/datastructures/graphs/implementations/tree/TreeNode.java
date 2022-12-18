package helper.util.datastructures.graphs.implementations.tree;

import helper.util.annotations.DataStructure;
import helper.util.datastructures.graphs.implementations.edge.Edge;
import helper.util.datastructures.graphs.implementations.node.Node;

import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("unused")
@DataStructure(mutable = false, threadSafe = false, lazy = false, fixedSize = true, fixedType = false)
public final class TreeNode<
		V, // Value
		N extends Node<N, V, E>, // Node
		E extends Edge<N> // Edge
		> extends Node<N, V, E> {

	public final TreeNode<V, N, E> parent;

	private final Set<TreeNode<V, N, E>> children = new HashSet<>();

	public TreeNode(V value) {
		this(null, value);
	}

	public TreeNode(TreeNode<V, N, E> parent, V value) {
		super(value);
		this.parent = parent;
	}

	public Set<TreeNode<V, N, E>> getChildren() {
		return Set.copyOf(children);
	}

	public boolean isRoot() {
		return parent == null;
	}

	public boolean isLeaf() {
		return children.isEmpty();
	}

	public void appendChild(V value) {
		children.add(new TreeNode<>(this, value));
	}
}
