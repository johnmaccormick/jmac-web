
import java.util.*;
import java.text.*;

/**
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Feb. 17, 2006
 */
public class FCFSnoIO implements Kernel {

    @SuppressWarnings("unchecked")
	private Vector readyQueue;

    @SuppressWarnings("unchecked")
	public FCFSnoIO() {
        readyQueue = new Vector(5, 5);
    }

    @SuppressWarnings("unchecked")
	public void systemCall(int callID, String param, SystemTimer timer) {
        if (callID == Kernel.START_PROCESS) {
            // Create a PCB for the new process
            // and put it on the back of the ready queue.
            readyQueue.add(new ProcessControlBlock(param));
        }
        else if (callID == Kernel.TERMINATE_PROCESS) {
            // Assume the first process in the ready queue is the
            // one that is running and remove it.
            readyQueue.remove(0);
        }
        else if (callID == Kernel.IO_REQUEST) {
            // This would execute if the executing process
            // were to make an I/O request.
        }
        else if (callID == Kernel.MAKE_DEVICE) {
            // This is executed at system startup once for each
            // device listed in the devices file.
        }
    }

    public void interrupt(String deviceID, SystemTimer timer) {
        if (deviceID.equals("TIMER")) {
            // This would execute if a TIMER intrrupt occurs.
        }
        else {
            // This would run if the interrupt came from a
            // device. Hopefully there was a MAKE_DEVICE call for
            // the device earlier - but keep in mind that there is
            // a chance the device doesn't exist. In that case
            // throwing an exception would be a logical choice.
        }
    }

    public String running(SystemTimer timer) {
        // Simple FCFS scheduling assumes that the process at
        // the front of the ready queue is the process in the
        // running state.
        if (readyQueue.size() > 0) {
            String proc = ((ProcessControlBlock) (readyQueue.firstElement()))
                    .getName();
            return proc;
        }
        else {
            return "Idle";
        }
    }

    public void terminate(SystemTimer timer) {
        System.out.println("System Time: " + timer.getSystemTime());
        System.out.println("Kernel Time: " + timer.getKernelTime());
        System.out.println("  User Time: " + timer.getUserTime());
        System.out.println("  Idle Time: " + timer.getIdleTime());

        // Compute the CPU Utilization...
        NumberFormat pctFmt = NumberFormat.getPercentInstance();
        pctFmt.setMinimumFractionDigits(2);
        pctFmt.setMaximumFractionDigits(2);
        System.out.println("CPU Utilization: "
                + pctFmt.format((double) timer.getUserTime()
                        / timer.getSystemTime()));
    }
}