/**
 * Starter code for the Roller Coaster Problem.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Mar 21, 2006
 */
public class RollerCoaster {

    public static int trainMax;
    
    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
        }

        int totPass = 0;
        int maxPass = 0;
        try {
            totPass = Integer.parseInt(args[0]);
            maxPass = Integer.parseInt(args[1]);
            trainMax = maxPass;
            if (totPass % maxPass != 0) {
                printUsage();
            }
        }
        catch (NumberFormatException e) {
            printUsage();
        }

        System.out.println("P:\t\t\t\t|T:");
        System.out.print("Wan\tInL\tOn\tOff\t|");
        System.out.println("Ld\tRun\tUnL");
        System.out.println("-------------------------"
                + "----------------------------");

        Thread train = new TrainThread();
        train.start();

        Thread[] pass = new Thread[totPass];
        for (int i = 0; i < totPass; i++) {
            pass[i] = new PassengerThread(i);
            pass[i].start();
        }
        for (int i = 0; i < totPass; i++) {
            try {
                pass[i].join();
            }
            catch (InterruptedException e) {
                System.out.println(e);
                System.exit(-1);
            }
        }

        System.exit(0);
    }

    private static void printUsage() {
        System.out.println("Usage: java RollerCoaster <totPass> <maxPass>");
        System.out.println("  <totPass>: Total number of passenger threads.");
        System.out.println("  <maxPass>: Number of passengers per train.");
        System.out.println("      NOTE: <totPass> must be divisible by <maxPass>");
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

class PassengerThread extends Thread {
    
    private int id;
    
    public PassengerThread(int id) {
        this.id = id;
    }
    
    public void run() {
        wanderPark();
        getInLine();
        getOnTrain();
        getOffTrain();
    }

    private void wanderPark() {
        System.out.println("P" + id + "\t\t\t\t|");
        RollerCoaster.randomSleep(1000);
    }

    private void getInLine() {
        System.out.println("\tP" + id + "\t\t\t|");
    }

    private void getOnTrain() {
        System.out.println("\t\tP" + id + "\t\t|");
    }

    private void getOffTrain() {
        System.out.println("\t\t\tP" + id + "\t|");
    }
}

class TrainThread extends Thread {
    public void run() {
        while (true) {
            loadPassengers();
            runALoop();
            unloadPassengers();
        }
    }

    private void loadPassengers() {
        System.out.println("\t\t\t\t|Tr");
    }

    private void runALoop() {
        System.out.println("\t\t\t\t|\tTr");
        RollerCoaster.randomSleep(1000);
    }

    private void unloadPassengers() {
        System.out.println("\t\t\t\t|\t\tTr");
    }
}