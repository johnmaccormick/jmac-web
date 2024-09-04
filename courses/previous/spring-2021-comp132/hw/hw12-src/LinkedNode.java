
public class LinkedNode {
	private Object element;
	private LinkedNode next;
	
	public LinkedNode(Object element) {
		this.element = element;
		this.next = null;
	}

	public LinkedNode(Object element, LinkedNode next) {
		this.element = element;
		this.next = next;
	}

	/**
	 * @return the next
	 */
	public LinkedNode getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(LinkedNode next) {
		this.next = next;
	}

	/**
	 * @return the element
	 */
	public Object getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(Object element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return element.toString();
	}
	
	
	
}
