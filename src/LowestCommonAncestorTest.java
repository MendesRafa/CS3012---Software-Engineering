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
}
