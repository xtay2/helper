package helper.util.datastructures.graphs.implementations.graph;

import helper.util.annotations.DataStructure;
import helper.util.datastructures.graphs.abstractions.GraphAlgorithm;
import helper.util.datastructures.graphs.algorithms.*;
import helper.util.datastructures.graphs.implementations.edge.Edge;
import helper.util.datastructures.graphs.implementations.edge.WeightedEdge;
import helper.util.datastructures.graphs.implementations.node.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@SuppressWarnings("unused")
@DataStructure(mutable = true, threadSafe = false, lazy = false, fixedSize = false, fixedType = false)
public class Graph<
		V, // Value
		N extends Node<N, V, E>,
		E extends Edge<N>> {

	private final Map<N, Set<E>> nodes = new HashMap<>();

	public Graph() {}

	public Graph(Map<N, Set<E>> nodes) {
		nodes.values().forEach(this::addEdges);
	}

	// Modifying behaviour has to be protected and made public by the implementing classes.

	protected boolean addNode(N node) {
		return nodes.putIfAbsent(node, new HashSet<>()) == null;
	}

	protected boolean addEdge(N node1, N node2) {
		return addEdge(Edge.connect(node1, node2));
	}

	protected boolean addEdge(E edge) {
		return nodes.getOrDefault(edge.x, new HashSet<>()).add(edge);
	}

	protected void addEdges(E... edges) {
		addEdges(Set.of(edges));
	}

	protected void addEdges(Iterable<E> edges) {
		edges.forEach(this::addEdge);
	}

	// Read-only behaviour.

	/** Performs a {@link GraphAlgorithm} on this graph. */
	public <R> R runAlgo(GraphAlgorithm<R> algorithm) {
		return algorithm.solve();
	}

	/** Returns all nodes in this graph in an immutable {@link Set}. */
	public final Set<N> nodes() {
		return nodes.keySet();
	}

	/**
	 * Returns the amount of nodes in this graph.
	 */
	public final int nodeCount() {
		return nodes.size();
	}

	/**
	 * Returns the immediate neighbours of a node.
	 * If this graph {@link #isDirected()} only the nodes that the passed one points to are returned.
	 */
	public Set<N> neighbours(N node) {
		return nodes.get(node).stream()
				.map(edge -> edge.y)
				.collect(Collectors.toUnmodifiableSet());
	}

	/** Returns all edges in this graph in an immutable {@link Set}. */
	public final Set<E> edges() {
		return nodes.values().stream()
				.flatMap(Set::stream)
				.collect(Collectors.toSet());
	}

	/** Returns an edge between two nodes or null if it doesn't exist. */
	public Edge<N> edge(N node1, N node2) {
		return nodes.get(node1).stream()
				.filter(edge -> edge.y.equals(node2))
				.findAny()
				.orElse(null);
	}

	/**
	 * Returns the amount of edges in this graph.
	 */
	public final int edgeCount() {
		return edges().size();
	}

	/**
	 * Returns true if this graph contains no nodes or edges.
	 *
	 * @implies {@link #isComplete()}
	 * @implies {@link #isPath()}
	 * @implies {@link #isTree()}
	 */
	public final boolean isEmpty() {
		return nodes.isEmpty() || edges().isEmpty();
	}

	/**
	 * Returns true if this graph contains the passed node.
	 */
	public final boolean contains(N node) {
		return nodes.containsKey(node);
	}

	/**
	 * Returns true if this graph contains at least one cycle.
	 */
	public boolean hasCycle() {
		return runAlgo(new HasCycles<>(this));
	}

	/**
	 * Returns true if this graph contains at least one negative weight.
	 *
	 * @implies {@link #isWeighted()}
	 */
	public boolean hasNegativeWeights() {
		return edges().stream().anyMatch(e -> e instanceof WeightedEdge<?, ?, ?> we && we.isNegative());
	}

	/**
	 * Returns true if this graph contains a cycle which has a negative edge.
	 *
	 * @implies {@link #hasCycle()}
	 * @implies {@link #hasNegativeWeights()}
	 */
	public boolean hasNegativeCycle() {
		return runAlgo(new HasNegativeCycles<>(this));
	}

	/**
	 * Returns true if the graph contains no walk in which a node is repeated.
	 *
	 * @implies {@link #isTree()}
	 * @implies {@link #isDirected()}
	 */
	public boolean isPath() {
		return runAlgo(new IsPath<>(this));
	}

	/**
	 * Returns true if the graph has no cycle and a root node.
	 *
	 * @implies {@link #isConnected()}
	 */
	public boolean isTree() {
		return isConnected() && !hasCycle();
	}

	/**
	 * Returns true if the graph is one cycle.
	 *
	 * @implies {@link #hasCycle()}
	 */
	public boolean isCycle() {
		return hasCycle() && nodeCount() == edgeCount();
	}

	/**
	 * Returns true if all nodes in this are indirectly connected through paths.
	 * The direction of these paths is irrelevant.
	 * If this graph #isEmpty() it is also connected.
	 */
	public boolean isConnected() {
		return runAlgo(new Connected<>(this));
	}

	/**
	 * Returns true if the graph contains at least one edge that has no inverse counterpart.
	 */
	public boolean isDirected() {
		return edges().stream().anyMatch(e -> edge(e.y, e.x) == null);
	}

	/**
	 * Returns true if every edge in this graph extends {@link WeightedEdge}.
	 */
	public boolean isWeighted() {
		return edges().stream().allMatch(e -> e instanceof WeightedEdge<?, ?, ?>);
	}

	/**
	 * Returns true if every node in this graph is
	 * directly connected to every other node.
	 */
	public boolean isComplete() {
		return runAlgo(new Complete<>(this));
	}
}