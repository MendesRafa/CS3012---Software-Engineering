import java.util.List;

public class LowestCommonAncestor {

	public static Node findLCA(Node root, Node firstNode, Node secondNode) {
		if (isNodeValid(root, firstNode) && isNodeValid(root, secondNode)) {
			return findLCARecursive(root, firstNode, secondNode);
		} else {
			return null;
		}
	}

	public static Node findLCARecursive(Node root, Node firstNode, Node secondNode) {
		if (root == null) {
			return null;
		}
		if ((firstNode.value == root.value) || (secondNode.value == root.value)) {
			return root;
		}
		Node left = findLCARecursive(root.leftChild, firstNode, secondNode);
		Node right = findLCARecursive(root.rightChild, firstNode, secondNode);
		if (left != null && right != null) {
			return root;
		}
		Node ancestor = ((left == null) ? right : left);
		return ancestor;
	}

	// checks if the LCA arguments are valid
	public static boolean isNodeValid(Node root, Node targetNode) {
		if (root == null || targetNode == null) {
			return false;
		}
		if (root.value == targetNode.value) {
			return true;
		}

		return isNodeValid(root.leftChild, targetNode) || isNodeValid(root.rightChild, targetNode);
	}
	
	public static int findLCADigraph(Digraph graph, int v, int w) {
		if(graph.E!=0 && graph.isVertexValid(v) && graph.isVertexValid(w)) {
			if (!isCyclic(graph)) {
				return 1;
			}
			else {
				throw new RuntimeException("Graph is not Acyclic");
			}
		}
		else {
			throw new IllegalArgumentException("Invalid inputs, graph has no edges or vertices are not in the graph");
		}
	}
	
	public static boolean isCyclic(Digraph graph) {
		boolean[] visitedNodes = new boolean [graph.V];
		boolean[] recursionStack = new boolean [graph.V];
		
		for (int i=0; i<graph.V; i++) {
			if(isCyclicRecursive(i, visitedNodes, recursionStack, graph)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isCyclicRecursive(int i, boolean[] visitedNodes, boolean[] recursionStack, Digraph graph) {
		if(recursionStack[i]) {
			return true;
		}
		if(visitedNodes[i]) {
			return false;
		}
		
		visitedNodes[i] = true;
		recursionStack[i] = true;
		
		List<Integer> children = graph.adj.get(i);
		
		for (Integer c : children) {
			if(isCyclicRecursive(c, visitedNodes, recursionStack, graph)) {
				return true;
			}
		}
		
		recursionStack[i] = false;
		
		return false;
	}
	
	public static int findRoot(Digraph graph) {
		int vertex=0;
		for (int i=0; i<graph.V; i++) {
			if (graph.indegree(i)==0){
				vertex=i;
			}
		}
		return vertex;
	}
}
