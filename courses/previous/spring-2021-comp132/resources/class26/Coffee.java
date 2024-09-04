
public class Coffee {

	private void createTemporaryFile() {
		// implementation omitted
		System.out.println("created temporary file");
	}

	private void deleteTemporaryFile() {
		// implementation omitted
		System.out.println("deleted temporary file");
	}

	public boolean drink(String description) throws CoffeeException {
		if (!description.contains("strong")) {
			throw new CoffeeException("This coffee is too weak");
		}
		return true;
	}

	public void takeASip(String description) {
		try {
			drink(description);
		} catch (CoffeeException e) {
			System.out.println("CoffeeException: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("NullPointerException: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Coffee coffee = new Coffee();
		coffee.createTemporaryFile();
		try {
			// Throws a NullPointerException, which won't be caught
			coffee.drink(null);
		} catch (CoffeeException e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			coffee.deleteTemporaryFile();
		}
	}

}
