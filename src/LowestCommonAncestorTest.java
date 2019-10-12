import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LowestCommonAncestorTest {

	@Test
	public void testConstructor() {
		new LowestCommonAncestor();
	}

	@Test
	public void testIsNodeValidWithEmptyGraph() {
		Node root = null;

		Node targetNode = null;
		assertFalse(LowestCommonAncestor.isNodeValid(root, targetNode),
				"If the graph is empty and the node is null then inputs are not valid");

		targetNode = new Node(1);
		assertFalse(LowestCommonAncestor.isNodeValid(root, targetNode),
				"If the graph is empty and the node is NOT null then the inputs are not valid");
	}

	@Test
	public void tesIsNodeValidWithTrivialGraph() {
		Node root = new Node(1);

		Node targetNode = new Node(1);
		assertTrue(LowestCommonAncestor.isNodeValid(root, targetNode),
				"In the trivial graph if the targetNode is equal to the root it IS VALID");

		targetNode = new Node(2);
		assertFalse(LowestCommonAncestor.isNodeValid(root, targetNode),
				"In the trivial graph if the targetNode is NOT equal to the root it IS NOT VALID");
	}

	@Test
	public void testIsNodeValidBinaryTree() {
		Node root = new Node(1);
		root.leftChild = new Node(2);
		root.rightChild = new Node(3);
		root.leftChild.leftChild = new Node(4);
		root.leftChild.rightChild = new Node(5);
		root.rightChild.leftChild = new Node(6);
		root.rightChild.rightChild = new Node(7);
		//@formatter:off
		//        __1__
		//      /     	\
		//    _2_       _3_
		//  /     \   / 	\
		// 4       5 6       7 
		//@formatter:on

		Node targetNode = null;
		assertFalse(LowestCommonAncestor.isNodeValid(root, targetNode),
				"In a BinaryTree if the targetNode is null then it is invalid");

		targetNode = new Node(1);
		assertTrue(LowestCommonAncestor.isNodeValid(root, targetNode),
				"In a BinaryTree if the targetNode is found in it then it is valid");
		targetNode = new Node(2);
		assertTrue(LowestCommonAncestor.isNodeValid(root, targetNode),
				"In a BinaryTree if the targetNode is found in it then it is valid");
		targetNode = new Node(3);
		assertTrue(LowestCommonAncestor.isNodeValid(root, targetNode),
				"In a BinaryTree if the targetNode is found in it then it is valid");
		targetNode = new Node(4);
		assertTrue(LowestCommonAncestor.isNodeValid(root, targetNode),
				"In a BinaryTree if the targetNode is found in it then it is valid");
		targetNode = new Node(5);
		assertTrue(LowestCommonAncestor.isNodeValid(root, targetNode),
				"In a BinaryTree if the targetNode is found in it then it is valid");
		targetNode = new Node(6);
		assertTrue(LowestCommonAncestor.isNodeValid(root, targetNode),
				"In a BinaryTree if the targetNode is found in it then it is valid");
		targetNode = new Node(7);
		assertTrue(LowestCommonAncestor.isNodeValid(root, targetNode),
				"In a BinaryTree if the targetNode is found in it then it is valid");

		targetNode = new Node(8);
		assertFalse(LowestCommonAncestor.isNodeValid(root, targetNode),
				"In a BinaryTree if the targetNode is NOT found in it then it is NOT valid");

	}

	@Test
	public void testFindLCASimpleGraph() {
		Node root = new Node(1);
		root.rightChild = new Node(2);
		root.rightChild.rightChild = new Node(3);
		//@formatter:off
		// 1
		//	\
		//	 2
		//	  \
		//     3
		//@formatter:on

		Node firstNode = new Node(3);
		Node secondNode = new Node(2);
		assertEquals(LowestCommonAncestor.findLCA(root, firstNode, secondNode).value, 2,
				"In this simple graph the LCA of 2 and 3 is 2");

		firstNode = new Node(1);
		secondNode = new Node(2);
		assertEquals(LowestCommonAncestor.findLCA(root, firstNode, secondNode).value, 1,
				"In this simple graph the LCA of 1 and 2 is 1");

		firstNode = new Node(3);
		secondNode = new Node(1);
		assertEquals(LowestCommonAncestor.findLCA(root, firstNode, secondNode).value, 1,
				"In this simple graph the LCA of 1 and 3 is 1");

		firstNode = null;
		secondNode = new Node(1);
		assertNull(LowestCommonAncestor.findLCA(root, firstNode, secondNode),
				"Make sure null is returned upon an invalid input");
		firstNode = new Node(3);
		secondNode = null;
		assertNull(LowestCommonAncestor.findLCA(root, firstNode, secondNode),
				"Make sure null is returned upon an invalid input");
		firstNode = new Node(4);
		secondNode = new Node(1);
		assertNull(LowestCommonAncestor.findLCA(root, firstNode, secondNode),
				"Make sure null is returned upon an invalid input");
		firstNode = new Node(2);
		secondNode = new Node(5);
		assertNull(LowestCommonAncestor.findLCA(root, firstNode, secondNode),
				"Make sure null is returned upon an invalid input");
	}

	@Test
	public void testFindLCABinaryTree() {
		Node root = new Node(1);
		root.leftChild = new Node(2);
		root.rightChild = new Node(3);
		root.leftChild.leftChild = new Node(4);
		root.leftChild.rightChild = new Node(5);
		root.rightChild.leftChild = new Node(6);
		root.rightChild.rightChild = new Node(7);
		//@formatter:off
		//        __1__
		//      /     	\
		//    _2_       _3_
		//  /     \   / 	\
		// 4       5 6       7 
		//@formatter:on

		Node firstNode = new Node(6);
		Node secondNode = new Node(7);
		assertEquals(LowestCommonAncestor.findLCA(root, firstNode, secondNode).value, 3,
				"In this simple graph the LCA of 6 and 7 is 3");

		firstNode = new Node(4);
		secondNode = new Node(3);
		assertEquals(LowestCommonAncestor.findLCA(root, firstNode, secondNode).value, 1,
				"In this simple graph the LCA of 4 and 3 is 1");

		firstNode = new Node(1);
		secondNode = new Node(5);
		assertEquals(LowestCommonAncestor.findLCA(root, firstNode, secondNode).value, 1,
				"In this simple graph the LCA of 1 and 5 is 1");

		firstNode = new Node(1);
		secondNode = new Node(2);
		assertEquals(LowestCommonAncestor.findLCA(root, firstNode, secondNode).value, 1,
				"In this simple graph the LCA of 1 and 2 is 1");

		firstNode = new Node(2);
		secondNode = new Node(3);
		assertEquals(LowestCommonAncestor.findLCA(root, firstNode, secondNode).value, 1,
				"In this simple graph the LCA of 2 and 3 is 1");

		firstNode = null;
		secondNode = new Node(1);
		assertNull(LowestCommonAncestor.findLCA(root, firstNode, secondNode),
				"Make sure null is returned upon an invalid input");
		firstNode = new Node(3);
		secondNode = null;
		assertNull(LowestCommonAncestor.findLCA(root, firstNode, secondNode),
				"Make sure null is returned upon an invalid input");
		firstNode = new Node(50);
		secondNode = new Node(1);
		assertNull(LowestCommonAncestor.findLCA(root, firstNode, secondNode),
				"Make sure null is returned upon an invalid input");
		firstNode = new Node(2);
		secondNode = new Node(9999);
		assertNull(LowestCommonAncestor.findLCA(root, firstNode, secondNode),
				"Make sure null is returned upon an invalid input");
	}

	@Test
	public void testIsAcyclic () {
		Digraph testGraph = new Digraph(0);
		assertFalse(LowestCommonAncestor.isCyclic(testGraph), "Since this graph is empty there should be no cycles");
		
		testGraph = new Digraph(1);
		testGraph.addEdge(0, 0);
		assertTrue(LowestCommonAncestor.isCyclic(testGraph),"When a vertex has an edge which goes to itsel then the graph has a cycle");
		
		testGraph = new Digraph(4);
		assertFalse(LowestCommonAncestor.isCyclic(testGraph), "This graph is only made up of vertices but no edges so it shouldn't have a cycle");
		
		testGraph.addEdge(0, 1);
		testGraph.addEdge(1, 2);
		testGraph.addEdge(2, 3);
		
		assertFalse(LowestCommonAncestor.isCyclic(testGraph), "Since this graph has no cycles it is not cyclic");
		
		testGraph.addEdge(3, 0);
		assertTrue(LowestCommonAncestor.isCyclic(testGraph), "Since this graph has a cycle it is cyclic");
	}
	
	@Test
	public void testLCADigraphInvalidInputs () {
		
		
		assertThrows(IllegalArgumentException.class, () -> {
			Digraph testGraph = new Digraph(0);
			int result = LowestCommonAncestor.findLCADigraph(testGraph, 1, 2);
		}, "If an empty graph is passed as the parameter to find the LCA an exception is thrown");
	
		
		assertThrows(IllegalArgumentException.class, () -> {
			Digraph testGraph = new Digraph(2);
			int result = LowestCommonAncestor.findLCADigraph(testGraph, 0, 1);
		}, "If a graph with no edges is passed as the parameter to find the LCA an exception is thrown");
		
		
		assertThrows(IllegalArgumentException.class, () -> {
			Digraph testGraph = new Digraph(2);
			testGraph.addEdge(0, 1);
			int result = LowestCommonAncestor.findLCADigraph(testGraph, 3, 0);
		}, "If one of the vertices passed as inputs is invalid then an exception is thrown");
		
		assertThrows(IllegalArgumentException.class, () -> {
			Digraph testGraph = new Digraph(2);
			testGraph.addEdge(0, 1);
			int result = LowestCommonAncestor.findLCADigraph(testGraph, 0, -1);
		}, "If one of the vertices passed as inputs is invalid then an exception is thrown");
		
		
		assertThrows(RuntimeException.class, () -> {
			Digraph testGraph = new Digraph(2);
			testGraph.addEdge(0, 1);
			testGraph.addEdge(1, 0);
			int result = LowestCommonAncestor.findLCADigraph(testGraph, 1, 0);
		}, "If the graph passed as an input has a cycle it is invalid so an exception is thrown");
		
	}
	
	@Test
	//no need to test edge cases as this function is called after those are taken into account
	public void testFindDigraphRoot() {
		Digraph testGraph = new Digraph(4);
		testGraph.addEdge(0,1);
		testGraph.addEdge(0, 2);
		testGraph.addEdge(1, 3);
		testGraph.addEdge(2, 3);
		//@formatter:off
		//	 0
		//  / \
		// v   v
		// 1   2
		// \   /
		//  v v
		//   3
		//@formatter:on
		
		assertEquals(0, LowestCommonAncestor.findDigraphRoot(testGraph), "In the above graph the only node with indegree 0 is node 0 and therefore the root of the graph");
		
		
		testGraph = new Digraph(7);
		testGraph.addEdge(6, 5);
		testGraph.addEdge(6, 4);
		testGraph.addEdge(4, 2);
		testGraph.addEdge(5, 3);
		testGraph.addEdge(2, 1);
		testGraph.addEdge(3, 1);
		testGraph.addEdge(1, 0);
		//@formatter:off
		//	 6
		//  / \
		// v   v
		// 4   5
		// |   |
		// v   v
		// 2   3
		// |   /
		// v  /
		// 1<- 
		// |
		// v
		// 0
		//@formatter:on
		assertEquals(6, LowestCommonAncestor.findDigraphRoot(testGraph), "In the above graph the only node with indegree 0 is node 6");
		
		testGraph = new Digraph(13);
		testGraph.addEdge(0, 1);
		testGraph.addEdge(0, 2);
		testGraph.addEdge(1, 3);
		testGraph.addEdge(1, 5);
		testGraph.addEdge(2, 4);
		testGraph.addEdge(4, 6);
		testGraph.addEdge(4, 7);
		testGraph.addEdge(6, 9);
		testGraph.addEdge(9, 8);
		testGraph.addEdge(9, 12);
		testGraph.addEdge(9, 10);
		testGraph.addEdge(10, 11);
		//@formatter:off
		//			   0
		//			  / \
		//			 v   v
		//			 1   2
		//			/     \
		//		   v       v
		//		   3       4 
		//		  /       / \
		//		 v	     v   v
		//		 5	  	 7   6
		//			         |
		//			         v
		//			   8 <---9
		//        			/ \
		//				   v   v	
		//				  12   10
		//						\
		//						 v
		//						 11
		//@formatter:on
		assertEquals(0, LowestCommonAncestor.findDigraphRoot(testGraph), "In the graph above the only vertex with indegree 0 is vertex 0");
		
		testGraph = new Digraph(3);
		testGraph.addEdge(1, 0);
		//@formatter:off
		// 1-->0
		// 
		// 2
		//@formatter:on
		assertEquals(1, LowestCommonAncestor.findDigraphRoot(testGraph), "In this graph the only connected vertex with indegree 0 is vertex 2");
	}
	
	@Test
	public void testdigraphVertexDepth() {
		Digraph testGraph = new Digraph(4);
		testGraph.addEdge(0, 1);
		testGraph.addEdge(0, 2);
		testGraph.addEdge(1, 3);
		testGraph.addEdge(2, 3);
		//@formatter:off
		//	 0
		//  / \
		// v   v
		// 1   2
		// \   /
		//  v v
		//   3
		//@formatter:on
		int root=0;
		assertEquals(0, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 0), "The distance from vertex '0' to the root vertex '0' is 0 edge");
		assertEquals(1, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 1), "The distance from vertex '1' to the root vertex '0' is 1 edge");
		assertEquals(1, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 2), "The distance from vertex '2' to the root vertex '0' is 1 edge");
		assertEquals(2, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 3), "The distance from vertex '3' to the root vertex '0' is 2 edges");

		
		testGraph = new Digraph(7);
		testGraph.addEdge(6, 5);
		testGraph.addEdge(6, 4);
		testGraph.addEdge(4, 2);
		testGraph.addEdge(5, 3);
		testGraph.addEdge(2, 1);
		testGraph.addEdge(3, 1);
		testGraph.addEdge(1, 0);
		//@formatter:off
		//	 6
		//  / \
		// v   v
		// 4   5
		// |   |
		// v   v
		// 2   3
		// |   /
		// v  /
		// 1<- 
		// |
		// v
		// 0
		//@formatter:on
		root = 6;
		assertEquals(0, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 6), "The distance from vertex '6' to the root vertex '6' is 0 edge");
		assertEquals(1, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 5), "The distance from vertex '5' to the root vertex '6' is 1 edge");
		assertEquals(1, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 4), "The distance from vertex '4' to the root vertex '6' is 1 edge");
		assertEquals(2, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 3), "The distance from vertex '3' to the root vertex '6' is 2 edges");
		assertEquals(2, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 2), "The distance from vertex '2' to the root vertex '6' is 2 edges");
		assertEquals(3, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 1), "The distance from vertex '1' to the root vertex '6' is 3 edges");
		assertEquals(4, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 0), "The distance from vertex '0' to the root vertex '6' is 4 edges");
		
		testGraph = new Digraph(13);
		testGraph.addEdge(0, 1);
		testGraph.addEdge(0, 2);
		testGraph.addEdge(1, 3);
		testGraph.addEdge(3, 5);
		testGraph.addEdge(2, 4);
		testGraph.addEdge(4, 6);
		testGraph.addEdge(4, 7);
		testGraph.addEdge(6, 9);
		testGraph.addEdge(9, 8);
		testGraph.addEdge(9, 12);
		testGraph.addEdge(9, 10);
		testGraph.addEdge(10, 11);
		//@formatter:off
		//			   0
		//			  / \
		//			 v   v
		//			 1   2
		//			/     \
		//		   v       v
		//		   3       4 
		//		  /       / \
		//		 v	     v   v
		//		 5	  	 7   6
		//			         |
		//			         v
		//			   8 <---9
		//        			/ \
		//				   v   v	
		//				  12   10
		//						\
		//						 v
		//						 11
		//@formatter:on
		root = 0;
		assertEquals(0, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 0), "The distance from vertex '0' to the root vertex '0' is 0 edge");
		assertEquals(1, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 1), "The distance from vertex '1' to the root vertex '0' is 1 edge");
		assertEquals(1, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 2), "The distance from vertex '2' to the root vertex '0' is 1 edge");
		assertEquals(2, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 3), "The distance from vertex '3' to the root vertex '0' is 2 edges");
		assertEquals(2, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 4), "The distance from vertex '4' to the root vertex '0' is 2 edges");
		assertEquals(3, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 5), "The distance from vertex '5' to the root vertex '0' is 3 edges");
		assertEquals(3, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 6), "The distance from vertex '6' to the root vertex '0' is 3 edges");
		assertEquals(3, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 7), "The distance from vertex '7' to the root vertex '0' is 3 edges");
		assertEquals(5, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 8), "The distance from vertex '8' to the root vertex '0' is 5 edges");
		assertEquals(4, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 9), "The distance from vertex '9' to the root vertex '0' is 4 edges");
		assertEquals(5, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 10), "The distance from vertex '10' to the root vertex '0' is 5 edges");
		assertEquals(6, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 11), "The distance from vertex '11' to the root vertex '0' is 6 edges");
		assertEquals(5, LowestCommonAncestor.digraphVertexDepth(testGraph, root, 12), "The distance from vertex '12' to the root vertex '0' is 5 edges");
	}
}
