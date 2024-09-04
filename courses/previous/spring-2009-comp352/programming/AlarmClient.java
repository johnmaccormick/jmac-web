import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * An AlarmClient object can be used to schedule that an
 * alarm message will be sent to an AlarmServer at some
 * point in the future. The message is sent using version
 * 1.0 of the ALARM protocol. Please see the JavaDoc of the
 * AlarmServer class for a description of this protocol.
 * 
 * @author jmac
 * @date February 2009
 */
public class AlarmClient implements Runnable {
	// the IP and port number to which the alarm message
	// should be sent
	private InetAddress destAddress;
	private int destPort;

	// amount of time to wait before sending the alarm
	// message, in milliseconds
	private long waitTime;

	/**
	 * Create a new AlarmClient object to send an alarm
	 * message with the given properties.
	 * 
	 * @param destAddress
	 *            host to which alarm message will be sent
	 * @param destPort
	 *            port to which alarm message will be sent
	 * @param waitTime
	 *            amount of time to wait before sending the
	 *            alarm message, in milliseconds
	 */
	AlarmClient(InetAddress destAddress, int destPort,
			long waitTime) {
		this.destAddress = destAddress;
		this.destPort = destPort;
		this.waitTime = waitTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("Alarm will be sent to port "
				+ destPort + " on " + destAddress + " in "
				+ waitTime + " milliseconds.");
		// wait for the required number of milliseconds
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			System.out
					.println("Alarm was interrupted; exiting.");
			System.exit(1);
		}

		// open a connection to the alarm server
		Socket socket = null;
		try {
			socket = new Socket(destAddress, destPort);
		} catch (UnknownHostException e) {
			System.err.println("Error: unknown host.");
			return;
		} catch (IOException e) {
			System.err.println("Error: couldn't get I/O.");
			return;
		}
		OutputStream outputStream = null;
		try {
			outputStream = socket.getOutputStream();
		} catch (IOException e) {
			System.err
					.println("Error: couldn't get output stream");
			return;
		}

		// send the alarm message to the alarm server
		String message = AlarmServer.BEEPNOW_request + AlarmServer.ENDOFLINE;
		try {
			outputStream.write(message.getBytes());
		} catch (IOException e) {
			System.err
					.println("Error: couldn't write to output stream");
			return;
		}

		// System.out
		// .println("message sent, about to receive response");

		// receive a response from the alarm server
		InputStream is = null;
		try {
			is = socket.getInputStream();
		} catch (IOException e) {
			System.err
					.println("Error: couldn't get input stream");
			return;
		}
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String response = null;
		try {
			response = br.readLine();
		} catch (IOException e) {
			System.out
					.println("error reading response from alarm server");
			return;
		}

		// System.out.println("received response: " +
		// response);

		// check response and close connection
		if (!response.equals(AlarmServer.OK_response)) {
			System.out
					.println("unexpected response from alarm server:");
			System.out.println(response);
		}
		// else {
		// System.out.println("alarm sent successfully");
		// }
		try {
			socket.close();
		} catch (IOException e) {
			System.out
					.println("error closing connection to alarm server");
			return;
		}
		try {
			outputStream.close();
			is.close();
			isr.close();
			br.close();
		} catch (IOException e) {
			System.out
					.println("error closing input and output streams");
			return;
		}
	}

	private static void usage() {
		System.out
				.println("usage: java AlarmClient server_name server_port wait_time");
		System.out
				.println("  server_name, server_port identify where the alarm will be sent");
		System.out
				.println("  wait_time is the number of milliseconds before the alarm will be sent");
		System.exit(1);
	}

	/**
	 * @param args
	 *            server_name server_port wait_time -- see
	 *            usage() message for details
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			usage();
		}
		String serverHost = args[0];
		int port = 0, wait_time = 0;
		try {
			port = Integer.parseInt(args[1]);
			wait_time = Integer.parseInt(args[2]);
		} catch (NumberFormatException e) {
			usage();
		}
		InetAddress address = null;
		try {
			address = InetAddress.getByName(serverHost);
		} catch (UnknownHostException e) {
			System.out.println("unknown host: "
					+ serverHost);
			System.exit(1);
		}
		AlarmClient alarmClient = new AlarmClient(address,
				port, wait_time);
		// send the alarm message (there's no need to do it
		// in a separate thread here)
		alarmClient.run();
	}
}
