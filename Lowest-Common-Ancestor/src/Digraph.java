import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Digraph {
	public int V;
	public int E;
	public List<List<Integer>> adj;
	public int[] indegree;

	// Constructor for the Digraph data structure
	public Digraph(int V) {
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices passed must be bigger than or equal to zero");
		this.V = V;
		this.E = 0;
		this.indegree = new int[V];
		adj = new ArrayList<>(V);

		for (int i = 0; i < V; i++) {
			adj.add(new LinkedList<>());
		}
	}

	// Method to add an edge to the graph
	public void addEdge(int v, int w) {
		if (isVertexValid(v) && isVertexValid(w)) {
			if (!adj.get(v).contains(w)) {
				adj.get(v).add(w);
				this.indegree[w]++;
				this.E++;
			} else {
				throw new IllegalArgumentException("edge " + v + " -> " + w + " is already in the graph");
			}
		} else {
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
		}
	}

	// Method to find the indegree of a target vertex in the graph
	// Indegree: The number of edges directed into a vertex in a directed graph
	public int indegree(int v) {
		if (isVertexValid(v)) {
			return this.indegree[v];
		} else {
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
		}
	}

	// Method to return whether a given vertex exists in a graph or not
	public boolean isVertexValid(int v) {
		if (v < 0 || v >= V) {
			return false;
		} else
			return true;
	}

	// Method to return the reverse graph of a given Digraph i.e. the direction of
	// the edges is reversed
	public Digraph reverse() {
		Digraph reverse = new Digraph(this.V);
		for (int v = 0; v < this.V; v++) {
			for (int w : this.adj.get(v))
				reverse.addEdge(w, v);
		}
		return reverse;
	}
}
