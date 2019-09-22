import java.util.function.BooleanSupplier;

public class LowestCommonAncestor {

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
}
