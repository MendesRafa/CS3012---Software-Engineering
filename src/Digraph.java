import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Digraph {
	public int V;
	public int E;
	public List<List<Integer>> adj;

	public Digraph(int V) {
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices passed must be bigger than or equal to zero");
		this.V = V;
		this.E = 0;
		adj = new ArrayList<>(V);

		for (int i = 0; i < V; i++) {
			adj.add(new LinkedList<>());
		}
	}

	public void addEdge(int v, int w) {
		if (isVertexValid(v) && isVertexValid(w)) {
			if(!adj.get(v).contains(w)) {
				adj.get(v).add(w);
				this.E++;
			}
			else {
				throw new IllegalArgumentException("edge " + v + " -> " + w + " is already in the graph");
			}
		}
		else {
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
		}
	}
	
	public boolean isVertexValid(int v) {
		if(v<0 || v>=V) {
			return false;
		}
		else return true;
	}
}
