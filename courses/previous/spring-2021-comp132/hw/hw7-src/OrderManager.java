import java.util.ArrayList;
import java.util.HashMap;

/**
 * An OrderManager object manages a collection of Order objects.
 * 
 * @author jmac
 *
 */
public class OrderManager {
	// This is a map containing all the orders managed by this OrderManager
	// instance. In each mapping entry, the key is the ID number of the
	// order, and the value is the corresponding Order object.
	private HashMap<Integer, Order> orders;

	/**
	 * Create a new OrderManager object with a given list of orders.
	 * 
	 * @param orderList An ArrayList containing all the orders that will be
	 *                  managed by this OrderManager
	 */
	public OrderManager(ArrayList<Order> orderList) {
        // Fill in with your own code.
	}

	/**
	 * Get the Order object with the given ID number.
	 * 
	 * @param idNumber The ID number of the Order to be retrieved
	 * @return The Order with the given idNumber, or null if no such order
	 *         exists.
	 */
	public Order getOrder(int idNumber) {
        // Fill in with your own code.
	}

	/**
	 * Add an Order object to the collection of orders being managed.
	 * 
	 * @param order the Order object to be added
	 */
	public void addOrder(Order order) {
        // Fill in with your own code.
	}

	/**
	 * Remove an order from the collection of orders being managed.
	 * 
	 * @param idNumber The ID number of the Order to be removed
	 */
	public void removeOrder(int idNumber) {
        // Fill in with your own code.
	}

	/**
	 * Find the order of the highest value
	 * 
	 * @return The Order of highest value in the collection of orders being
	 *         managed, or null if no orders are being managed.
	 */
	public Order highestValueOrder() {
        // Fill in with your own code.
	}

}
