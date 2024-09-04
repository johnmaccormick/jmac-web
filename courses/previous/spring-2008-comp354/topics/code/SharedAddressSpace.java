

/**
 * Demonstration of the fact that threads share
 * the same address space.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Feb 21, 2006
 */
public class SharedAddressSpace {

    public static void main(String[] args) {
        int[] vals = {-1, -1, -1};
        
        Thread t0 = new myThread4(0,vals);
        Thread t1 = new myThread4(1,vals);
        Thread t2 = new myThread4(2,vals);
        
        t0.start();
        t1.start();
        t2.start();
        
        try {
            t0.join();
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
        }
        
        System.out.println("vals[0] = " + vals[0]);
        System.out.println("vals[1] = " + vals[1]);
        System.out.println("vals[2] = " + vals[2]);
    } 
}

class myThread4 extends Thread {
    private int id;
    private int[] array;
    
    public myThread4(int id, int[] array) {
        this.id = id;
        this.array = array;
    }
    
    public void run() {
      	array[id] = id;
    }
}
