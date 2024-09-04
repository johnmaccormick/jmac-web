/**
 * A class that illustrates the use of static methods in the Integer, Double and
 * Math classes from the Java SDK.
 * 
 * To run this program from a terminal:
 * - open a terminal
 * - cd into the Example-code project folder where ever it is.
 *   - ls should show comp132 as the only contents.
 * - use the command:
 *     java examples.staticex.JavaStaticMethods 3 4
 * - Try other values (e.g. 2.7 3.5) for the command line arguments.
 * - What happens if you use abc as an argument?
 * - Try computing other results (cube root, 5th power, etc)
 * 
 * @author Grant Braught, revisions by Farhan Siddiqui
 * @author Dickinson College
 * @version Aug 10, 2019
 */
public class JavaStaticMethods {

    public static void main(String[] args) {

        double x = 5.2;
        double y = 3.1;
        
        /*
         * Use static methods in the Math class to do the computation.
         */
        double xRaisedToY = Math.pow(x, y);
        double sqrtXRaisedToY = Math.sqrt(xRaisedToY);

        System.out.println("The square root of " + x + " raised to " + y + " is " + sqrtXRaisedToY);
    }
}
