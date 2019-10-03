
public class Digraph {
	public int V;
	public int E;
	public boolean[][] adj;
	
	public Digraph(int V) {
		if(V<0) throw new RuntimeException("Number of vertices passed must be bigger than or equal to zero");
		this.V=V;
		this.E=0;
		this.adj = new boolean [V][V];
	}

}
