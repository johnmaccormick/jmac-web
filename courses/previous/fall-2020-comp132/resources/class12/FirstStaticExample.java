/**
 * A first look at (non-final) static fields and static methods. This class does
 * not show any practical use, but illustrates the mechanics of how such fields
 * and methods behave.
 * 
 * @author Grant Braught, revisions by Farhan Siddiqui
 * @author Dickinson College
 * @version Aug 10, 2015
 */
public class FirstStaticExample {

	private static int x = 1; // a static field.
	private int y; // an instance field.

	public FirstStaticExample() {
		y = 5;
	}

	public void increaseXandY(int dx, int dy) {
		x = x + dx;	// instance method may static fields (class variables)
		y = y + dy;	// and also fields (instance variables)
		// or this.y = this.y + dy;
	}

	public static void decreaseX(int dx) {
		x = x - dx;
		// static means there is no "this" (i.e. no invoking object)!
		// so static methods cannot access fields (e.g. y).
	}

	public String toString() {
		return "x = " + x + " : y = " + y;
	}

	/**
	 * Example statements that illustrate the difference between static and instance
	 * fields.
	 */
	public static void main(String[] args) {
		FirstStaticExample fse1 = new FirstStaticExample();
		FirstStaticExample fse2 = new FirstStaticExample();

		fse1.increaseXandY(3, 4);  // use object reference to invoke instance method.
		System.out.println("fse1: " + fse1.toString());
		System.out.println("fse2: " + fse2);  // same as fse2.toString();

		fse2.increaseXandY(4, 5);
		System.out.println("fse1: " + fse1);
		System.out.println("fse2: " + fse2);

		FirstStaticExample.decreaseX(2);  // Use class name to invoke static method
		System.out.println("fse1: " + fse1);
		System.out.println("fse2: " + fse2);
	}
}
