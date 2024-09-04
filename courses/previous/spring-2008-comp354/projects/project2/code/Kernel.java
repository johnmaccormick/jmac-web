/**
 * Classes implementing this interface act as an operating system kernel in the
 * simulation. All system calls and interrupts generated during the simulation
 * are passed onto the kernel to be processed.
 * 
 * <p>
 * Note that to be compatible with the simulation framework, all classes
 * implementing the Kernel interface must have only a no-arg constructor.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Mar 3, 2005
 */
public interface Kernel {

    /**
     * Constant representing a system call requesting that a new device be
     * created.
     */
    public final static int MAKE_DEVICE = 1;

    /**
     * Constant representing a system call indicating the creation of a new
     * process.
     */
    public final static int START_PROCESS = 2;

    /**
     * Constant representing a system call indicating that the currently running
     * process has requested an I/O operation.
     */
    public final static int IO_REQUEST = 3;

    /**
     * Constant representing a system call to terminate the currently running
     * process.
     */
    public final static int TERMINATE_PROCESS = 4;

    /**
     * This method is invoked each time a system call occurs. The valid system
     * calls include:
     * 
     * <pre>
     *               System Call ID:     		Parameter:
     *               ------------------------------------
     *               Kernel.MAKE_DEVICE			Device ID
     *               Kernel.IO_REQUEST			Device ID
     *               Kernel.START_PROCESS		Process Name
     *               Kernel.TERMINATE_PROCESS
     * </pre>
     * 
     * <p>
     * The MAKE_DEVICE system call is issued once for each device listed in the
     * devices file specified on the command line when the SystemDriver is
     * executed.
     * 
     * <p>
     * The IO_REQUEST system call is issued each time a user process requests
     * and I/O Operation. Note that any requests for operations on devices that
     * do not exist should cause the program to terminate with an error message.
     * 
     * <p>
     * The START_PROCESS system call is issued once for each process, at the
     * process' arrival time as specified in its data file. This system call
     * indicates the arrival of the process in the system.
     * 
     * <p>
     * The TERMINATE_PROCESS sytem call is issued once for each process, once
     * the process has completed its execution.
     */
    public void systemCall(int callID, String param, SystemTimer timer);

    /**
     * An interrupt may arrive from any I/O device created by a MAKE_DEVICE
     * system call or from the "TIMER" device. If an interrupt arrives from any
     * other device the scheduler should throw a runtime exception and
     *  
     */
    public void interrupt(String deviceID, SystemTimer timer);

    /**
     * Return the name of the process currently in the running state. When no
     * other process is ready to run the Kernel must report that the "Idle"
     * process is running.
     */
    public String running(SystemTimer timer);

    /**
     * This method is called when the simulation has completed. The code in this
     * method should compute statistics and display the results of the
     * simulation.
     */
    public void terminate(SystemTimer timer);
}