/**
 *  This code is not intended to acomplish
 * any useful computation, it is simply a demonstration of
 * array creation and manipulation.
 * 
 * @author Grant Braught, revised code by Farhan Siddiqui
 * 
 */
public class FirstArrayExample
{
    
    
    public static void main(String[] args) { 
    	double[] prices;
                      
        prices = new double[5];   
        
        prices[3] = 23.50;
        prices[1] = 99.39;
        
        for(int i=0;i<prices.length;i++) {
        	System.out.println(prices[i]);
        }
        System.out.println("---");
        
        double pr3 = prices[3];
        double pr2 = prices[2];
        
        prices[0] = 2*prices[1] + prices[3];
        
        for(int i=0;i<prices.length;i++) {
        	System.out.println(prices[i]);
        }
        System.out.println("---");
        
        
        int len = prices.length;
        
        System.out.println("length of the array is " + len);
    }
    
}
