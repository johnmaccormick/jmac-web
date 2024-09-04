/**
 * A motivating example for thread synchronization.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Mar 5, 2006
 */
public class ThreadSynchExample1 {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            Integer[] x = { new Integer(0) };

            Thread tc = new IncThread(x);
            Thread td = new DecThread(x);

            tc.start();
            td.start();

            try {
                tc.join();
                td.join();
            }
            catch (InterruptedException e) {
            }

            System.out.print(x[0] + "\t");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}

class IncThread extends Thread {

    private Integer[] x;

    public IncThread(Integer[] x) {
        this.x = x;
    }

    public void run() {
        for (int i = 0; i < 500000; i++) {
            x[0] = new Integer(x[0].intValue() + 1);
        }
    }
}

class DecThread extends Thread {

    private Integer[] x;

    public DecThread(Integer[] x) {
        this.x = x;
    }

    public void run() {
        for (int i = 0; i < 500000; i++) {
            x[0] = new Integer(x[0].intValue() - 1);
        }
    }
}