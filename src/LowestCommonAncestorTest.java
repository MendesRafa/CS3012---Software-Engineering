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
		 //      /     	 \
		 //    _2_       _3_
		 //  /     \   / 	 \
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
}
