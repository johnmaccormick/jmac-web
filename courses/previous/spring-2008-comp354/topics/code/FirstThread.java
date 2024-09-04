

/**
 * Simple example of creating a thread in Java.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Feb 21, 2006
 */
public class FirstThread {

    public static void main(String[] args) {
        System.out.println("Main thread running...");
        Thread t1 = new myThread(1);
        t1.start();
        System.out.println("Main thread finished...");
    }
}

class myThread extends Thread {
    
    private int id;
    
    public myThread(int id) {
        this.id = id;
    }
    
    public void run() {
        System.out.println("Thread " + id + " running...");
    }
}