package helper.util.datastructures.graphs.implementations.edge;

import helper.base.NumberHelper;
import helper.util.datastructures.graphs.implementations.node.Node;

public class WeightedEdge<
		S extends WeightedEdge<S, V, N>, // Self
		V extends Comparable<V>,
		N extends Node<N, V, S>>
		extends Edge<N> implements Comparable<WeightedEdge<S, V, N>> {

	public final V weight;

	public WeightedEdge(N x, N y, V weight) {
		super(x, y);
		this.weight = weight;
	}

	public boolean isNegative() {
		return weight instanceof Number n && NumberHelper.isNegative(n);
	}

	@Override
	public int compareTo(WeightedEdge<S, V, N> o) {
		return weight.compareTo(o.weight);
	}

}
