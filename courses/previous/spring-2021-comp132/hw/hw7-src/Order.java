/**
 * An Order object represents a customer's order of a certain number of
 * items at a certain price.
 * 
 * @author jmac
 *
 */
public class Order {
	private int idNumber; // unique ID number of this order
	private int quantity;
	private double price; // in dollars

	/**
	 * Create a new Order object
	 * 
	 * @param idNumber The unique ID number of this order
	 * @param quantity The number of items in this order
	 * @param price    The price of each item in this order, in dollars
	 */
	public Order(int idNumber, int quantity, double price) {
		this.idNumber = idNumber;
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * @return the idNumber
	 */
	public int getIdNumber() {
		return idNumber;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Get the total value of this order, computed as quantity multiplied
	 * by price.
	 * 
	 * @return Total value of this order
	 */
	public double getValue() {
		return quantity * price;
	}

}
