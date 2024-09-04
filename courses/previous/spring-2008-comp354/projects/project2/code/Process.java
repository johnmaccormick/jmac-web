import java.util.*;

/**
 * The Process class represents a single proces in 
 * the system.  An object of type Process will hold
 * all of the information from the data file corresponding
 * to the procsess.
 */
public class Process {
    
    private String processName;
    private int arrivalTime;
    @SuppressWarnings("unchecked")
	private Vector processOps;
    private int opCounter;
    private int cpuBurstRemaining;

    /**
     * Construct a new Process with the specified
     * name and arrival time.
     *
     * @param name the name of this Process.
     * @param arrivalTime the time at which this Process starts.
     * @param osKernel the Kernel to which system calls and interrupts should
     *                 be passed.
     */
    @SuppressWarnings("unchecked")
	public Process(String name, int arrivalTime, Kernel osKernel) {
        processOps = new Vector(20,20);
        processName = name;
        this.arrivalTime = arrivalTime;
        opCounter = 0;
        cpuBurstRemaining = 0;
    }

    /** 
     * Determine if this Process object and the Process object referred to by
     * o are the same Process.  They are considered to be the same Process if 
     * they have the same name.
     *
     * @param o reference to the Process object to be compared to this Process.
     */
    public boolean equals(Object o) {
        return processName.equals(((Process)o).processName);
    }

    /**
     * Add a ProcessOperation to this process.
     *
     * @param pOp the ProcessOperation to be added to this process.
     */
    @SuppressWarnings("unchecked")
	public void addOp(ProcessOperation pOp) {
        processOps.add(pOp);
    }

    /**
     * Get the currently executing ProcessOperation from this Process.
     *
     * @return the currently executing ProcessOperation.
     */
    public ProcessOperation getOp() {
        return getOp(opCounter);
    }

    /**
     * Get the specified ProcessOperation from this Process.
     *
     * @param index the index of the ProcessOperation to be returned.
     * @return the specified ProcessOperation.
     */
    public ProcessOperation getOp(int index) {
        return (ProcessOperation)processOps.get(index);
    }

    /**
     * Get the name of this Process.
     *
     * @return the name of this process.
     */
    public String getName() {
        return processName;
    }

    /**
     * Get the arrival time of this Process.
     *
     * @return the arrival time of this process.
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Get the operation counter for this Process.
     * The operation counter indicates the index of the ProcessOperation
     * that is currently being processed.
     *
     * @return the operation counter for this Process.
     */
    public int getOpCounter() {
        return opCounter;
    }

    /**
     * Increment the operation counter for this process. This advances the
     * process onto the next phase of its execution.
     */
    public void advanceOpCounter() {
        opCounter++;

        ProcessOperation pOp = getOp();
        int theOp = pOp.getOpType();

        if (theOp == ProcessOperation.CPU) {
            cpuBurstRemaining = pOp.getOpTime();
        }
    }

    /**
     * Simulate the effect of allocating ticks worth of CPU time
     * to this Process.
     *
     * @param ticks the amount of CPU time allocated to this Process.
     */
    public void execute(int ticks) {
        ProcessOperation pOp = getOp();
        int theOp = pOp.getOpType();

        // A little defensive programming to make sure that a process that has already
        // executed its TERMINATE_PROCESS system call does not receive any CPU time!
        if (theOp == ProcessOperation.EXIT) {
            throw new RuntimeException("Process " + processName + 
                                       " has already terminated! " + 
                                       "it can not be executed!");
        }
        else {
            cpuBurstRemaining = cpuBurstRemaining - ticks;
            if (cpuBurstRemaining <= 0) {
                cpuBurstRemaining = 0;
                advanceOpCounter();
            }
        }
    }

    /** 
     * Determine if this process has finished its execution.
     *
     * @return true if this process has completed and false otherwise.
     */
    public boolean finished() {
        ProcessOperation pOp = getOp();
        int theOp = pOp.getOpType();
        return theOp == ProcessOperation.EXIT;
    }
    
    /**
     * Get the remaining CPU burst of this Process.
     *
     * @return the remaining CPU burst of this Process.  
     */
    public int getCPUBurstRemaining() {
        return cpuBurstRemaining;
    }
}


