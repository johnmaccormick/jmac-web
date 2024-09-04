

/**
 * Demonstration of the use of yield and join
 * in Java.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Feb 21, 2006
 */
public class YieldJoin {

    public static void main(String[] args) {
        
        System.out.println("Main starting...");
        
        Thread t1 = new myThread3(1);
        Thread t2 = new myThread3(2);
        
        t1.start();
        t2.start();
        
        System.out.println("Main waiting...");
        
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
        }
        
        System.out.println("Main ending...");
    }
}

class myThread3 extends Thread {
    private int id;
    
    public myThread3(int id) {
        this.id = id;
    }
    
    public void run() {
        for (int i=0; i<100; i++) {
            System.out.println("Thread " + id + " running...");
            Thread.yield();
        }
    }
}