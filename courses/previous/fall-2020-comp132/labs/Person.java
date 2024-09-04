

public class Person {
	
	
	private String firstName;
	private String lastName;
	private String email;
	
	public Person(String firstName, String lastName, String email) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	} 
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String newEmail) {
		email = newEmail;
	}

	public void print() {
		System.out.println("This person is " + firstName + " " + lastName + " and the person's email is " + email);
	}
	public static void main(String[] args) {
		
		
		Person p1 = new Person("Nayer", "Montgomery", "nayer@yahoo.com");
		p1.print();
	}

}
