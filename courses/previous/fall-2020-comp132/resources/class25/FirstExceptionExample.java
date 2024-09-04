/**
 * Class used to demonstrate the propagation of thrown exceptions. methodB
 * will throw an ArrayIndexOutOfBoundsExeption. As written that exception
 * will terminate methodB before the 2nd println. The exception will
 * propagate up to methodA, which called methodB. methodA will then
 * terminate at the call to methodB, before the final println. Similarly
 * for main. Then when an exception is propagated from main the program is
 * terminated.
 * 
 * The exception can be handled at any point by surrounding the code that
 * generates it with a try/catch block.
 * 
 * NOTE: System.err.println works the same as System.out.println but is
 * generally used for printing error information rather than information
 * for the user about normal operations.
 * 
 * @author Grant Braught, revisions by Farhan Siddiqui
 * @author Dickinson College
 * @version Aug 10, 2019
 */
public class FirstExceptionExample {

	public static void main(String[] args) {
		System.err.println("main starting");
		methodA();
		System.err.println("main ending");
	}

	public static void methodA() {
		System.err.println("methodA starting");
		methodB(10);
		System.err.println("methodA ending");
	}

//	public static void methodA() {
//		System.err.println("methodA starting");
//		try {
//			methodB();
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.err.println(e.getMessage());
//		}
//		System.err.println("methodA ending");
//	}

	public static void methodB(int index) {
		System.err.println("methodB starting");
		int[] arr = new int[5];
		arr[index] = 10; // Throws IndexOutOfBoundsException- why?
		System.err.println("methodB ending");
	}
}
