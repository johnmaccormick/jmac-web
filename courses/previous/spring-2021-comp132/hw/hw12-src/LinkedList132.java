/**
 * The LinkedList132 class is an implementation of the ListADT interface
 * based on a linked list. This simple version of a linked list has been
 * developed for teaching purposes in the Dickinson College course COMP132,
 * and should not be confused with the class java.util.LinkedList.
 * 
 * @author jmac, based on a related class by Grant Braught
 *
 */
public class LinkedList132 implements ListADT {

	private LinkedNode head;
	private int listSize;

	public LinkedList132() {
		head = null;
		listSize = 0;
	}

	///////////////////////////////////////////////////////////
	/////////// Begin implementation of ListADT interface /////
	///////////////////////////////////////////////////////////
	@Override
	public int size() {
		return listSize;
	}

	@Override
	public void add(Object element) {
		addNode(new LinkedNode(element));
		listSize++;
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		return getNode(index).getElement();
	}

	@Override
	public void set(int index, Object element)
			throws IndexOutOfBoundsException {
		LinkedNode targetNode = getNode(index);
		targetNode.setElement(element);
	}

	@Override
	public void insert(int index, Object element)
			throws IndexOutOfBoundsException {
		checkIndex(index);

		LinkedNode newNode = new LinkedNode(element);
		if (index == 0) {
			insertNodeAtHead(newNode);
		} else {
			// Note the "minus 1" here, since we are trying to insert
			// *before* index, but the only available private helper method
			// inserts *after*.
			LinkedNode targetNode = getNode(index - 1);
			insertNodeAfter(newNode, targetNode);
		}
		listSize++;
	}

	@Override
	public Object remove(int index) throws IndexOutOfBoundsException {
		checkIndex(index);

		LinkedNode removed = null;
		if (index == 0) {
			removed = removeHead();
		} else {
			removed = removeNodeAfter(getNode(index - 1));
		}
		listSize--;
		return removed.getElement();
	}

	///////////////////////////////////////////////////////////
	/////////// End implementation of ListADT interface ///////
	///////////////////////////////////////////////////////////

	/**
	 * Add the given node to the end of the list.
	 * 
	 * @param node The node to be added.
	 */
	private void addNode(LinkedNode node) {
		if (listSize == 0) {
			head = node;
		} else {
			LinkedNode targetNode = getNode(listSize - 1);
			insertNodeAfter(node, targetNode);
		}
	}

	/**
	 * Get the node at the given index.
	 * 
	 * @param index The index of the node to get.
	 * @return The node at the given index.
	 * @throws IndexOutOfBoundsException
	 */
	private LinkedNode getNode(int index)
			throws IndexOutOfBoundsException {
		checkIndex(index);
		LinkedNode current = head;
		for (int i = 0; i < index; i++) {
			if (current != null) {
				current = current.getNext();
			} else {
				break;
			}
		}
		return current;
	}

	/**
	 * Check that the given index is valid.
	 * 
	 * To be valid, the index must be between zero (inclusive) and the list
	 * size (exclusive).
	 * 
	 * @param index The index whose validity will be checked.
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= listSize) {
			throw new IndexOutOfBoundsException("invalid index " + index);
		}
	}

	/**
	 * Remove the node after the given node.
	 * 
	 * @param pred The predecessor the node to be removed.
	 * @return A reference to the removed node.
	 */
	private LinkedNode removeNodeAfter(LinkedNode pred) {
		LinkedNode toRemove = pred.getNext();
		LinkedNode successor = toRemove.getNext();
		pred.setNext(successor);
		return toRemove;
	}

	/**
	 * Remove the node at the head of the list.
	 * 
	 * @return A reference to the removed node--that is, the previous head
	 *         of the list
	 */
	private LinkedNode removeHead() {
		LinkedNode prevHead = head;
		head = head.getNext();
		return prevHead;
	}

	/**
	 * Insert newNode after pred node.
	 * 
	 * @param newNode The node to be inserted into the list
	 * @param pred    The node after which newNode will be inserted.
	 */
	private void insertNodeAfter(LinkedNode newNode, LinkedNode pred) {
		LinkedNode successor = null;
		if (pred == null) {
			successor = head;
			head = newNode;
		} else {
			successor = pred.getNext();
			pred.setNext(newNode);
		}
		newNode.setNext(successor);
	}

	/**
	 * Insert the given node at the head of the list.
	 * 
	 * @param newNode The node to be inserted at the head of the list.
	 */
	private void insertNodeAtHead(LinkedNode newNode) {
		newNode.setNext(head);
		head = newNode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LinkedNode node = head;
		String separator = ", ";
		while (node != null) {
			sb.append(node.toString() + separator);
			node = node.getNext();
		}
		// Return everything except the last separator.
		if (sb.length() > 0) {
			return sb.substring(0, sb.length() - separator.length());
		} else {
			return "";
		}

	}

	///////////////////////////////////////////////////////////
	/////////// Begin homework methods //////////////////////
	///////////////////////////////////////////////////////////

	/**
	 * Count the number of nodes that come after a given node in the list.
	 * 
	 * @param node The node after which we begin counting.
	 * @return The number of nodes after the given node.
	 */
	public int countNodesAfter(LinkedNode node) {
		return -1;
	}

	/**
	 * Swap the node after pred1 with the node after pred2
	 * 
	 * @param pred1 Predecessor of first node to be swapped.
	 * @param pred2 Predecessor of second node to be swapped.
	 */
	public void swap(LinkedNode pred1, LinkedNode pred2) {

	}

	/**
	 * Move the successor of the given node to a position n items later in
	 * the list.
	 * 
	 * @param pred The predecessor of the node that will be moved.
	 * @param n    The number of positions to move the successor of pred.
	 */
	public void jumpByN(LinkedNode pred, int n) {

	}
	
	public static void main(String[] args) {
		LinkedList132 list = new LinkedList132();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		
		// The following will give correct results when homework is complete.
		System.out.println("Original list:");
		System.out.println(list);
		System.out.println("Count of nodes after node 2:");
		System.out.println(list.countNodesAfter(list.getNode(2)));
		System.out.println("After swapping successors of nodes 1 and 3:");
		list.swap(list.getNode(1), list.getNode(3));
		System.out.println(list);
		System.out.println("After jumping successor of node 1 ahead by 2:");
		list.jumpByN(list.getNode(1), 2);
		System.out.println(list);
	}
}
