import java.util.*;

/**
 * Objects of type ProcessOperation represent a single 
 * logcial operation of a process: Either a CPU burst
 * or a system call.
 */
public class ProcessOperation {

    public static final int CPU = 1;
    public static final int IO = 2;
    public static final int WAIT = 3;
    public static final int NOTIFY = 4;
    public static final int NOTIFY_ALL = 5;
    public static final int START = 6;
    public static final int EXIT = 7;

    private int opType;
    private String opDevice;
    private int opTime;
    private Process parent;

    /**
     * Construct a new ProcessOperation from the line of the
     * process' data file.
     *
     * @param line a line from the process's data file.  The
     *             format of these lines is defined in the
     *             SystemDriver class.
     * @param parent the Process to which this ProcessOperation belongs.
     * 
     * @see SystemDriver
     */
    public ProcessOperation(String line, Process parent) {

        this.parent = parent;

        line = line.toUpperCase().trim();

        if (line.startsWith("START")) {
            opType = START;
        }
        else if (line.startsWith("EXIT")) {
            opType = EXIT;
        }
        else if (line.startsWith("CPU")) {
            opType = CPU;
            opTime = Integer.parseInt(line.substring(3).trim());
        }
        else if (line.startsWith("WAIT")) {
            opType = WAIT;
            opDevice = line.substring(4).trim();
        }
        else if (line.startsWith("NOTIFY")) {
            opType = NOTIFY;
            opDevice = line.substring(6).trim();
        }
        else if (line.startsWith("NOTIFY_ALL")) {
            opType = NOTIFY_ALL;
            opDevice = line.substring(10).trim();
        }
        else if (line.startsWith("IO")) {
            opType = IO;
            StringTokenizer st = new StringTokenizer(line.substring(3).trim(), "\t ");
            opDevice = st.nextToken();
            opTime = Integer.parseInt(st.nextToken());   
        }
        else {
            throw new UnsupportedOperationException(
                  "Unrecognized operation in: " + line);
        }
    }

    /**
     * Get the type of operation represented by the ProcessOperation. The
     * value returned will be one of the constants defined in this class.
     *
     * @return the type of operation represented by this ProcessOperation.
     */
    public int getOpType() {
        return opType;
    }

    /**
     * Get the device on which the operation represented by this
     * ProcessOperation is to be performed.
     *
     * @return the device for this ProcessOperation.
     */
    public String getOpDevice() {
        return opDevice;
    }

    /**
     * Get the time required for the operation represented by
     * this ProcessOperation.
     *
     * @return the time required for this ProcessOperation.
     */
    public int getOpTime() {
        return opTime;
    }

    /**
     * Get the parent Process for this ProcessOperation.
     *
     * @return the parent Process for this ProcessOperation.
     */
    public Process getParent() {
        return parent;
    }

    /** 
     * Generate a string representation of this ProcessOperation.
     * 
     * @return a string representation of this ProcessOperation.
     */
    public String toString() {
        switch(opType) {
        case CPU: return parent.getName() + ": CPU " + opTime;
        case IO: return parent.getName() + ": IO " + opDevice + " " + opTime;
        case WAIT: return parent.getName() + ": WAIT " + opDevice;
        case NOTIFY: return parent.getName() + ": NOTIFY " + opDevice;
        case NOTIFY_ALL: return parent.getName() + ": NOTIFY_ALL " + opDevice;
        case START: return parent.getName() + ": START";
        case EXIT: return parent.getName() + ": EXIT";
        default: return "oops.";
        }
    }
}


