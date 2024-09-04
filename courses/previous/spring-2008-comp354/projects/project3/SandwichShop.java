/**
 * Starter code for the Sandwich Shop Problem
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Mar 21, 2006
 */
public class SandwichShop {

    public static void main(String[] args) {
        if (args.length != 1) {
            printUsage();
        }

        int num = 0;
        try {
            num = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e) {
            printUsage();
        }

        System.out.println("C:\t\t\t\t\t\t|E:");
        System.out.print("Tra\tArr\tOrd\tBro\tReg\tLea");
        System.out.println("\t|Wt\tMak\tReg\tAcc");
        System.out .println("---------------------"
                        + "------------------------"
                        + "---------------------");

        Thread emp = new EmployeeThread();
        emp.start();

        Thread[] custs = new Thread[num];
        for (int i = 0; i < num; i++) {
            custs[i] = new CustomerThread(i);
            custs[i].start();
        }
        for (int i = 0; i < num; i++) {
            try {
                custs[i].join();
            }
            catch (InterruptedException e) {
            }
        }

        System.exit(0);
    }

    private static void printUsage() {
        System.out.println("Usage: java SandwichShop <num>");
        System.out.println("  <num>: Number of customers.");
        System.exit(-1);
    }

    public static void randomSleep(int max) {
        try {
            Thread.sleep((int) (Math.random() * max));
        }
        catch (InterruptedException e) {
				System.out.println(e);
				System.exit(-1);
        }
    }
}

class CustomerThread extends Thread {

    private int id;

    public CustomerThread(int id) {
        this.id = id;
    }

    public void run() {
        travelToShop();
        arriveAtShop();
        placeOrder();
        browseShop();
        atRegister();
        leaveShop();
    }

    private void travelToShop() {
        System.out.println("C" + id + "\t\t\t\t\t\t|");
        SandwichShop.randomSleep(1000);
    }

    private void arriveAtShop() {
        System.out.println("\tC" + id + "\t\t\t\t\t|");
    }

    private void placeOrder() {
        System.out.println("\t\tC" + id + "\t\t\t\t|");
    }

    private void browseShop() {
        System.out.println("\t\t\tC" + id + "\t\t\t|");
        SandwichShop.randomSleep(1000);
    }

    private void atRegister() {
        System.out.println("\t\t\t\tC" + id + "\t\t|");
    }

    private void leaveShop() {
        System.out.println("\t\t\t\t\tC" + id + "\t|");
    }
}

class EmployeeThread extends Thread {

    public void run() {
        while (true) {
            waitForCustomer();
            makeSandwich();
            atCashRegister();
            paymentAccepted();
        }
    }

    private void waitForCustomer() {
        System.out.println("\t\t\t\t\t\t|Em");
    }

    private void makeSandwich() {
        System.out.println("\t\t\t\t\t\t|\tEm");
        SandwichShop.randomSleep(1000);
    }

    private void atCashRegister() {
        System.out.println("\t\t\t\t\t\t|\t\tEm");
    }

    private void paymentAccepted() {
        System.out.println("\t\t\t\t\t\t|\t\t\tEm");
    }
}