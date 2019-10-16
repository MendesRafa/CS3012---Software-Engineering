import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncestor {

	// Method which finds the Lowest Common Ancestor of node u and v in a Binary
	// Tree
	public static Node findLCA(Node root, Node firstNode, Node secondNode) {
		if (isNodeValid(root, firstNode) && isNodeValid(root, secondNode)) {
			return findLCARecursive(root, firstNode, secondNode);
		} else {
			return null;
		}
	}

	// Recursive util method used for finding the Lowest Common Ancestor of node u
	// and v in a Binary Tree
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

	// Method which checks if a Node is present in a Binary Tree
	public static boolean isNodeValid(Node root, Node targetNode) {
		if (root == null || targetNode == null) {
			return false;
		}
		if (root.value == targetNode.value) {
			return true;
		}

		return isNodeValid(root.leftChild, targetNode) || isNodeValid(root.rightChild, targetNode);
	}

	// Method which finds the Lowest Common Ancestor of node v and w in a Digraph
	// Constraints of this method: Digraph must have only one root i.e. only one
	// root which has indegree=0
	public static int findLCADigraph(Digraph graph, int v, int w) {
		if (graph.E != 0 && graph.isVertexValid(v) && graph.isVertexValid(w)) {
			if (!isCyclic(graph)) {
				int root = findDigraphRoot(graph);
				List<Integer> firstAncestors = digraphVertexAncestors(graph, root, v);
				List<Integer> secondAncestors = digraphVertexAncestors(graph, root, w);

				int[] firstAncestorsArray = firstAncestors.stream().mapToInt(i -> (int) i).toArray();
				int[] secondAncestorsArray = secondAncestors.stream().mapToInt(i -> (int) i).toArray();

				int j, k, tmp, depth;

				List<Integer> commonAncestors = new ArrayList<Integer>();

				for (j = 0; j < firstAncestorsArray.length; j++) {
					for (k = 0; k < secondAncestorsArray.length; k++) {
						if (firstAncestorsArray[j] == secondAncestorsArray[k]) {
							commonAncestors.add(firstAncestorsArray[j]);
						}
					}
				}

				int[] commonAncestorsArray = commonAncestors.stream().mapToInt(i -> (int) i).toArray();

				for (j = 1; j < commonAncestorsArray.length; j++) {
					tmp = commonAncestorsArray[j];
					depth = digraphVertexDepth(graph, root, commonAncestorsArray[j]);
					for (k = j - 1; k >= 0; k--) {
						if (depth > digraphVertexDepth(graph, root, commonAncestorsArray[k])) {
							commonAncestorsArray[k + 1] = commonAncestorsArray[k];
							commonAncestorsArray[k] = tmp;
						}
					}
				}

				return commonAncestorsArray[0];
			} else {
				throw new RuntimeException("Graph is not Acyclic");
			}
		} else {
			throw new IllegalArgumentException("Invalid inputs, graph has no edges or vertices are not in the graph");
		}
	}

	// Method which checks if a Digraph contains a Cycle or not
	public static boolean isCyclic(Digraph graph) {
		boolean[] visitedNodes = new boolean[graph.V];
		boolean[] recursionStack = new boolean[graph.V];

		for (int i = 0; i < graph.V; i++) {
			if (isCyclicRecursive(i, visitedNodes, recursionStack, graph)) {
				return true;
			}
		}
		return false;
	}

	// Recursive util method which traverses graph checking for cycles
	private static boolean isCyclicRecursive(int i, boolean[] visitedNodes, boolean[] recursionStack, Digraph graph) {
		if (recursionStack[i]) {
			return true;
		}
		if (visitedNodes[i]) {
			return false;
		}

		visitedNodes[i] = true;
		recursionStack[i] = true;

		List<Integer> children = graph.adj.get(i);

		for (Integer c : children) {
			if (isCyclicRecursive(c, visitedNodes, recursionStack, graph)) {
				return true;
			}
		}

		recursionStack[i] = false;

		return false;
	}

	// Find the first vertex in the list of vertices in the Digraph which has
	// indegree=0 i.e. the first vertex which is considered to be a root
	public static int findDigraphRoot(Digraph graph) {
		int vertex = 0;
		for (int i = 0; i < graph.V; i++) {
			if (graph.indegree(i) == 0 && !graph.adj.get(i).isEmpty()) {
				vertex = i;
			}
		}
		return vertex;
	}

	// Find the depth of a target vertex where depth is defined as the distance from
	// the vertex to the root
	public static int digraphVertexDepth(Digraph graph, int root, int vertex) {
		Stack<Integer> visited = new Stack<Integer>();
		int depth = 0;
		return digraphVertexDepthRecursive(graph, root, vertex, depth, visited);
	}

	// Recursive util method which traverses the graph to find the depth of a vertex
	// i.e. distance between the vertex and the selected root
	private static int digraphVertexDepthRecursive(Digraph graph, int currentVertex, int targetVertex, int depth,
			Stack<Integer> visitedVertices) {
		if (currentVertex == targetVertex) {
			visitedVertices.push(currentVertex);
			return visitedVertices.size() - 1;
		}

		visitedVertices.push(currentVertex);

		Iterator<Integer> i = graph.adj.get(currentVertex).listIterator();
		while (i.hasNext()) {
			int newVertex = i.next();
			if (!visitedVertices.contains(newVertex)) {
				depth = digraphVertexDepthRecursive(graph, newVertex, targetVertex, depth, visitedVertices);
				if (!visitedVertices.empty()) {
					visitedVertices.pop();
				}
			}
		}
		return depth;
	}

	// Method which returns a list of vertices which are the ancestors of a target
	// vertex
	public static List<Integer> digraphVertexAncestors(Digraph graph, int root, int vertex) {
		List<Integer> visited = new ArrayList<Integer>();
		List<Integer> ancestors = new ArrayList<Integer>();
		Digraph reversedGraph = graph.reverse();
		ancestors.addAll(digraphVertexAncestorsRecursive(reversedGraph, vertex, visited));
		return ancestors;
	}

	// Recursive method util which traverses the graph and adds ancestors to the
	// vertex to a list which is returned at the end
	private static List<Integer> digraphVertexAncestorsRecursive(Digraph graph, int currentVertex,
			List<Integer> visited) {
		visited.add(currentVertex);

		Iterator<Integer> i = graph.adj.get(currentVertex).listIterator();
		while (i.hasNext()) {
			int newVertex = i.next();
			if (!visited.contains(newVertex)) {
				digraphVertexAncestorsRecursive(graph, newVertex, visited);
			}
		}

		return visited;
	}
}
