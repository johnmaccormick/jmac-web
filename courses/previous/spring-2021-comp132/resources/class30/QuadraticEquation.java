/**
 * QuadraticEquation can be used to solve quadratic equations. Here we use
 * it to demonstrate some elementary refactoring techniques and the use of
 * command line arguments.
 * 
 * @author jmac
 */
public class QuadraticEquation {

	/**
	 * The following three fields represent the coefficients in a standard
	 * quadratic equation written as
	 * 
	 * a x^2 + b x + c = 0
	 */
	double a;
	double b;
	double c;

	/**
	 * Construct a quadratic equation with the given coefficients, i.e.
	 * 
	 * a x^2 + b x + c = 0
	 * 
	 * @param a Coefficient of x^2
	 * @param b Coefficient of x
	 * @param c Constant coefficient
	 */
	public QuadraticEquation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Solve the quadratic equation.
	 * 
	 * @return The larger of the two roots of the quadratic equation (or
	 *         NaN if there are no solutions).
	 */
	public double solve() {
		return (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
	}

	@Override
	public String toString() {
		return a + "x^2 + " + b + "x + " + c + " = 0";
	}

	public static void main(String[] args) {
		QuadraticEquation q1 = new QuadraticEquation(1, -1, -6);
		QuadraticEquation q2 = new QuadraticEquation(1, 2, -4);

		System.out.println(
				"equation is " + q1 + ", solution is " + q1.solve());
		System.out.println(
				"equation is " + q2 + ", solution is " + q2.solve());
	}

	/**
	 * This main method can be used to demonstrate the use of command line
	 * arguments.
	 * 
	 * @param args The quadratic coefficients a, b, c are the expected
	 *             command line arguments.
	 */
//	public static void main(String[] args) {
//		double a = Double.parseDouble(args[0]);
//		double b = Double.parseDouble(args[1]);
//		double c = Double.parseDouble(args[2]);
//
//		QuadraticEquation q = new QuadraticEquation(a, b, c);
//
//		System.out.println(
//				"equation is " + q + ", solution is " + q.solve());
//	}

}
