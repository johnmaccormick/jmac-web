
/**
 * This class is used to demonstrate the execution
 * of our first while loop example.
 * 
 * @author Grant Braught
 * 
 */
public class FirstWhileLoop
{
    public void whileLoopDemo() {
        int x=0;
        while (x < 5) {
            System.out.println(x);
            x = x + 1;
        }
    }
    
    public static void main(String[] args) {
    	FirstWhileLoop loopDemo = new FirstWhileLoop();
    	
    	loopDemo.whileLoopDemo();
    }
}
