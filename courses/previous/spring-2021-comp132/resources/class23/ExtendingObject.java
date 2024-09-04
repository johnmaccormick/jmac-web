import java.util.ArrayList;

/**
 * This class demonstrates some of the implications of and effects caused by
 * having all classes in Java implicitly extend Object.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version May 22, 2015
 */

/**
 * The One class inherits the default implementations of toString and equals
 * from the Object class.
 */
class One {  // extends Object is implied!
	private int x;
	
	public One(int x) {
		this.x = x;
	}
}

/**
 * The Two class overrides the toString and the equals methods that it inherited
 * from Object.
 */
class Two {  // extends Object is implied!
	private int x;

	public Two(int x) {
		this.x = x;
	}

	public String toString() {
		return "Class Two: " + x;
	}

	public boolean equals(Object other) {
		Two otherTwo = ((Two)other);
		return this.x == otherTwo.x;
	}
}

public class ExtendingObject {

	/**
	 * Demonstrates that println automatically invokes the toString method on an
	 * object. This can be done because every class inherits that method from
	 * Object. The default implementation simply returns the object reference.
	 * Class Two overrides toString to return a more meaningful representation
	 * of the object.
	 */
	public static void toStringExample() {
		One one = new One(1);
		Two two = new Two(2);
		
		// The toString inherited from Object simply returns the object
		// reference.
		System.out.println("one: " + one);
		System.out.println("one: " + one.toString());

		// Class Two overrides the inherited toString method.
		System.out.println("two: " + two);
		System.out.println("two: " + two.toString());
	}

	/**
	 * Demonstrates inherited and overridden equals methods. The equals method
	 * inherited from Object by class One compares object references, checking
	 * if the two references refer to the exact same object. The overridden
	 * equals method defined in class Two compares the values in the object's
	 * fields to see if they are the same. Thus, two different objects with the
	 * same values can be considered equal.
	 */
	public static void equalsExample() {
		One one = new One(1);
		One uno = new One(1);
		// The equals inherited from Object compares object references.
		System.out.println("one.equals(uno):  " + one.equals(uno));	  // false
		
		One eins = one;
		System.out.println("one.equals(eins): " + one.equals(eins));  // true
		
		
		Two two = new Two(2);
		Two dos = new Two(2);
		// The overridden equals in Two compares the field values.
		System.out.println("two.equals(dos):  " + two.equals(dos));  // true
		
		Two zwei = two;
		Two deux = new Two(3);
		System.out.println("two.equals(zwei): " + two.equals(zwei));  // true
		System.out.println("two.equals(deux): " + two.equals(deux));  // false
	}

	/**
	 * Because Java knows all objects will have an equals method it can make use
	 * of that to define reusable algorithms. For example the ArrayList class
	 * has methods contains, indexOf, lastIndexOf and remove that invoke equals
	 * in their operation. This allows these methods to operate on any type of
	 * object.
	 */
	public static void equalsUseByJavaExample() {
		ArrayList<Two> twoList = new ArrayList<Two>();
		twoList.add(new Two(1));
		twoList.add(new Two(2));
		twoList.add(new Two(3));
		
		// contains method uses equals to check the list for an "equal" object.
		System.out.println("contains first: " + twoList.contains(new Two(1)));
		System.out.println("contains second: " + twoList.contains(new Two(2)));
		System.out.println("contains fourth: " + twoList.contains(new Two(4)));
		
		// indexOf also use equals to find the index of the first "equal" object.
		System.out.println("indexOf third: 	" + twoList.indexOf(new Two(3)));
		System.out.println("indexOf fourth: " + twoList.indexOf(new Two(4)));
		
		// remove also uses equals to find the "equal" object to be removed.
		System.out.println("contains third: " + twoList.contains(new Two(3)));
		twoList.remove(new Two(3));
		System.out.println("contains third: " + twoList.contains(new Two(3)));	
	}

	/**
	 * Invokes the methods in this class to demonstrate the toString and
	 * equals methods.
	 */
	public static void main(String[] args) {

		System.out.println("toStringExample():");
		toStringExample();

		System.out.println();
		System.out.println("equalsExample():");
		equalsExample();
		
		System.out.println();
		System.out.println("equalsUseByJavaExample():");
		equalsUseByJavaExample();
	}
}
