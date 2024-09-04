import java.util.Vector;
import java.util.LinkedList;

public class VectorExperiment {
	// create a list with the given number of elements,
	// and time how long it takes to remove all elements
	// from the list when the removals are done one at a time
	// from the head of the list.
	// Actually, we do the above for two different list implementations:
	// Vector, and LinkedList
	public static void do_experiment(int num_elements) {

		// Vectors first
		
		// create the list and add elements to it
		Vector<MyClass> v = new Vector<MyClass>();
		for (int i = 0; i < num_elements; i++) {
			v.add(new MyClass(i));
		}
		
		// time how long it takes to remove elements
		// from the head of the list, one at a time
		long start = System.nanoTime();
		for (int i = 0; i < num_elements; i++) {
			v.remove(0);
		}
		long stop = System.nanoTime();
		long duration = stop - start;
		
		// print out results
		System.out.println("Vector: " + num_elements + ", " + duration);

		
		// LinkedLists second
		
		// create the list and add elements to it
		LinkedList<MyClass> l = new LinkedList<MyClass>();
		for (int i = 0; i < num_elements; i++) {
			l.add(new MyClass(i));
		}

		// time how long it takes to remove elements
		// from the head of the list, one at a time
		start = System.nanoTime();
		for (int i = 0; i < num_elements; i++) {
			l.remove(0);
		}
		stop = System.nanoTime();
		duration = stop - start;

		// print out results
		System.out.println("LinkedList: " + num_elements + ", " + duration);
	
	
	}

	public static void main(String[] args) {

		// run the list experiment for numbers of elements
		// that are powers of 10 from 1 to 100000
		for (int i = 0; i < 6; i++) {
			do_experiment((int) Math.pow(10,i));
		}
	}
}

class MyClass {
	int x;

	MyClass(int x) {
		this.x = x;
	}
}