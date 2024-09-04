import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * An AlarmServer listens for requests from an AlarmClient,
 * using version 1.0 of the ALARM protocol. This protocol
 * has only a single message type, "BEEPNOW". On receiving a
 * BEEPNOW message, the server will not actually make a
 * beeping sound, but will print a message to the console
 * starting with the words "BEEP BEEP BEEP BEEP".
 * AlarmServer implements the Runnable interface so that the
 * server can be run in a new thread if desired.
 * 
 * @author jmac
 * @date February 2009
 */
public class AlarmServer implements Runnable {
	public static final String VERSION = "ALARM/1.0";
	public static final String ENDOFLINE = "\r\n";
	public static final String BEEPNOW_request = "BEEPNOW"
			+ " " + VERSION;
	public static final String OK_response = "200 OK" + " "
			+ VERSION;
	public static final String UNKNOWNREQUEST_response = "400 UNKNOWNREQUEST"
			+ " " + VERSION;
	// socket on which server will listen for new
	// connections
	private ServerSocket serverSocket;
	// true if the server socket is established, false
	// otherwise
	private boolean ready;

	/**
	 * Create a new AlarmServer object. The AlarmServer will
	 * not begin listening for requests until its run()
	 * method is invoked.
	 */
	public AlarmServer() {
		serverSocket = null;
		ready = false;
	}

	/**
	 * @return the port on which the server is listening for
	 *         new connections, or -1 if the server is not
	 *         yet listening
	 */
	public synchronized int getPort() {
		if (!isReady()) {
			return -1;
		} else {
			return serverSocket.getLocalPort();
		}
	}

	/**
	 * is the server socket established yet?
	 */
	public synchronized boolean isReady() {
		return ready;
	}

	/**
	 * set whether or not the server socket is established
	 */
	private synchronized void setReady(boolean ready) {
		this.ready = ready;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		// 1. establish a server socket
		try {
			// the port number 0 indicates that the server
			// should choose an available port -- we can
			// find out which one was chosen using the
			// getPort() method
			serverSocket = new ServerSocket(0);
			// we are now ready to receive requests, so
			// record that fact
			setReady(true);
		} catch (IOException e) {
			System.out
					.println("Could not listen on any port");
			System.exit(1);
		}
		// 2. listen for requests in an infinite loop
		// try {
		listen();
		// } catch (Exception e) {
		// System.out
		// .println("AlarmServer caught exception while listening: "
		// + e);
		// }
	}

	/*
	 * executes an infinite loop listening for new
	 * connections on the server socket, accepting such
	 * connections and handling their requests in a separate
	 * thread
	 */
	private void listen() {
		// Establish the socket that will talk to the client
		Socket clientSocket = null;

		// Process service requests in an infinite
		// loop.
		while (true) {
			// Listen for a TCP connection request.
			try {
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.out.println("Accept failed");
				System.exit(1);
			}
			// Construct an object to process the ALARM
			// request message, and start it in a new
			// thread
			AlarmRequest request = new AlarmRequest(
					clientSocket);
			Thread thread = new Thread(request);
			thread.start();
		}
	}

	private static void usage() {
		System.out.println("usage: java AlarmServer");
		System.exit(0);
	}

	/**
	 * Run a new AlarmServer
	 * 
	 * @param argv
	 *            No arguments are required
	 * @throws InterruptedException
	 */
	public static void main(String argv[])
			throws InterruptedException {
		if (argv.length != 0) {
			usage();
		}
		AlarmServer alarmServer = new AlarmServer();
		Thread thread = new Thread(alarmServer);
		thread.start();
		while (!alarmServer.isReady()) {
			System.out
					.println("waiting for alarm server to start...");
			Thread.sleep(500);
		}
		System.out
				.println("Alarm server is listening on port "
						+ alarmServer.getPort());
	}

}

/**
 * An AlarmRequest handles a request to an alarm server. It
 * is intended to be run in a separate thread from the
 * server itself, and hence implements the Runnable
 * interface.
 * 
 * @author jmac
 */
final class AlarmRequest implements Runnable {
	// for communicating with the client
	private Socket clientSocket;

	/**
	 * Create a new request object that will process the
	 * request arriving on the given socket
	 * 
	 * @param clientSocket
	 *            socket on which the request arrived
	 */
	public AlarmRequest(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			processRequest();
		} catch (IOException e) {
			System.out
					.println("IOException while processing alarm request: "
							+ e);
		}
	}

	private void checkVersion(String requestLine) {
		if (!requestLine.endsWith(AlarmServer.VERSION)) {
			System.out
					.println("Bad version warning: expected "
							+ AlarmServer.VERSION
							+ ", but received request");
			System.out.println(requestLine);
			System.out.println("Processing will continue, "
					+ "but this is a bad sign!");
		}
	}

	// process the request from the client socket
	private void processRequest() throws IOException {
		// Get a reference to the socket's input and output
		// streams.
		InputStream is = clientSocket.getInputStream();
		DataOutputStream os = new DataOutputStream(
				clientSocket.getOutputStream());

		// Set up input stream filters.
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// Get the request line of the ALARM request
		// message.
		String requestLine = br.readLine();

		// System.out.println("received request: ");
		// System.out.println(requestLine);

		checkVersion(requestLine);

		String response;
		if (requestLine.equals(AlarmServer.BEEPNOW_request)) {
			// "sound" the alarm by printing out "BEEP
			// BEEP..."
			System.out
					.println("\n\nBEEP BEEP BEEP BEEP (yes, this is your wake up call)\n");
			response = AlarmServer.OK_response
					+ AlarmServer.ENDOFLINE;
		} else {
			System.out
					.println("received malformed request from alarm client");
			response = AlarmServer.UNKNOWNREQUEST_response
					+ AlarmServer.ENDOFLINE;
		}
		os.write(response.getBytes());
		// Close streams and socket.
		os.close();
		br.close();
		try {
			clientSocket.close();
		} catch (IOException e) {
			System.out
					.println("IOException while trying to close the socket: "
							+ e);
			System.exit(1);
		}
	}
}
