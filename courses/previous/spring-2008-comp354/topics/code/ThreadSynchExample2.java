/**
 * A motivating example for thread synchronization.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Mar 5, 2006
 */
public class ThreadSynchExample2 {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            Integer[] x = { new Integer(1), new Integer(2) };

            Thread ta = new threadA(x);
            Thread tb = new threadB(x);

            ta.start();
            tb.start();

            try {
                ta.join();
                tb.join();
            }
            catch (InterruptedException e) {
            }

            if (i % 10 == 0) {
                System.out.println();
            }
            else {
                System.out.print("\t");
            }
        }
    }
}

class threadA extends Thread {

    private Integer[] x;

    public threadA(Integer[] x) {
        this.x = x;
    }

    public void run() {
        doWork();
        x[0] = new Integer(5);
        doWork();
        System.out.print(x[0] + " ");
    }

    public void doWork() {
        for (int i = 0; i < 100000; i++) {
            Double z = new Double(Math.random());
        }
    }
}

class threadB extends Thread {

    private Integer[] x;

    public threadB(Integer[] x) {
        this.x = x;
    }

    public void run() {
        doWork();
        x[1] = new Integer(x[0].intValue() + 3);
        doWork();
        System.out.print(x[1] + " ");
    }

    public void doWork() {
        for (int i = 0; i < 100000; i++) {
            Double z = new Double(Math.random());
        }
    }
}