
/**
 * find the largest of 3 numbers.
 * 
 * @author Tim Wahls
 * @version 9/16/2005
 */
public class FindMax
{
    // the three numbers
    private int num1;
    private int num2;
    private int num3;

    /**
     * set the 3 numbers to find the max of
     * @param init1 first number
     * @param init2 second number
     * @param init3 third number
     */
    public FindMax(int init1, int init2, int init3)
    {
        num1 = init1;
        num2 = init2;
        num3 = init3;
    }

    /** return the maximum of the three numbers set by the constructor
     *  @return the maximum of the three numbers
     */
    public int max3() {
        int max = 0;
        if (num1 > num2) { // largest is not n2
            if (num1 > num3) {
                max = num1;
            } else {
                max = num3;
            }
        } else { // largest is not n1
            if (num2 > num3) {
                max = num2;
            } else {
                max = num3;
            }
        }
        return max;
    }
    
    /** return the maximum of the three numbers set by the constructor
     *  @return the maximum of the three numbers
     */
//     public int max3() {
//         int max = 0;
//         if (num1 is the largest) {
//             max = num1;      
//         } else if (num2 is the largest) {
//             max = num2;
//         } else { // num3 is the largest
//             max = num3;
//         }
//         return max;
//     }
//     
}
