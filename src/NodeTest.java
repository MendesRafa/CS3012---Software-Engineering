import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeTest {

	@Test
	// Test for the data type constructor
	public void testConstructor() {
		Node testNode = new Node(5);
		assertEquals(testNode.value, 5, "Check if the value of the generated node is correct");
		assertNull(testNode.rightChild, "Check if the value of the right child node is correct");
		assertNull(testNode.leftChild, "Check if the value of the left child node is correct");
	}

	@Test
	// Test the functionality for creating Trees from Nodes
	public void testConstructingASimpleBST() {
		Node root = new Node(1);
		root.rightChild = new Node(2);
		root.leftChild = new Node(3);
		assertEquals(root.value, 1, "Check if the value of the generated node is correct");
		assertEquals(root.rightChild.value, 2, "Check if the value of the right child node is correct");
		assertEquals(root.leftChild.value, 3, "Check if the value of the left child node is correct");
	}

}
