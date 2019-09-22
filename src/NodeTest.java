import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeTest {

	@Test
	public void testConstructor()
	{
		Node testNode = new Node(5);
		assertEquals(testNode.value, 5, "Check if the value of the generated node is correct");
		assertNull(testNode.rightChild, "Check if the value of the right child node is correct");
		assertNull(testNode.leftChild, "Check if the value of the left child node is correct");
	}

}
