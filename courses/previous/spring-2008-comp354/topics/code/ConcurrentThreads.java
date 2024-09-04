

/**
 * Example that creates several concurrently
 * executing threads in Java.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Feb 21, 2006
 */
public class ConcurrentThreads {

    public static void main(String[] args) {
        
        System.out.println("Main starting...");
        
        Thread t1 = new myThread2(1);
        Thread t2 = new myThread2(2);
        
        t1.start();
        t2.start();
        
        for (int i=0; i<1000; i++) {
            System.out.println("Main running");
        }
        
        System.out.println("Main ending...");
    }
}

class myThread2 extends Thread {
    private int id;
    
    public myThread2(int id) {
        this.id = id;
    }
    
    public void run() {
        for (int i=0; i<1000; i++) {
            System.out.println("Thread " + id + " running...");
        }
    }
}