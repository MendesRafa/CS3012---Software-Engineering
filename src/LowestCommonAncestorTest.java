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
}
