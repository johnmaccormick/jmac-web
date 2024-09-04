import java.util.ArrayList;

/**
 * A Node demonstrates a very simple application of
 * recursion. A Node object stores a single integer (its
 * "value"), and resides in a tree. Hence, a Node also has a
 * list of its children in the tree.
 * 
 * A Node can use recursion to determine whether the sum of
 * the values on any path from itself to a leaf in the tree
 * equals a given target amount.
 * 
 * @author jmac
 * @date April 2011
 */
public class Node {
	private int value;
	private ArrayList<Node> children;

	/**
	 * Construct a new Node with the given value
	 */
	public Node(int value) {
		this.value = value;
		children = new ArrayList<Node>();
	}

	/**
	 * Add the given child as a child of the current Node.
	 * @param child
	 */
	public void addChild(Node child) {
		children.add(child);
	}

	/**
	 * Return true if the sum of the values on any path from
	 * the current node to a leaf in the tree equals the
	 * given sum; otherwise return false. The target sum
	 * includes the value at the current node.
	 * 
	 * @param sum
	 *            The target value for a path from the
	 *            current node to a leaf.
	 * @return true if a path with the desired sum exists
	 */
	public boolean hasPathSum(int sum) {
		// compute the amount that must remain in the path
		// below this node
		int remainingSum = sum - value;
		if (children.size() == 0) {
			// We are at a leaf node, so return true if the
			// desired amount remaining is zero
			return remainingSum == 0;
		} else {
			// We are at an internal node, so use recursion.
			// Return true if any child has a path with the
			// desired sum, otherwise return false
			for (Node child : children) {
				if (child.hasPathSum(remainingSum)) {
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * Construct a simple tree and test for the existence of
	 * paths from the root with various target sum values.
	 * 
	 * @param args
	 *            Ignored
	 */
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);

		node1.addChild(node2);
		node1.addChild(node3);
		node2.addChild(node4);
		node2.addChild(node5);
		node2.addChild(node6);
		node6.addChild(node7);

		for (int i = 0; i < 20; i++) {
			System.out.println(i + ": "
					+ node1.hasPathSum(i));
		}
	}
}
