package PS6;

import java.io.*;
import java.net.Socket;

/**
 * Handles communication between the server and one client, for SketchServer
 *
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; revised Winter 2014 to separate SketchServerCommunicator
 */
public class SketchServerCommunicator extends Thread {
	private Socket sock;					// to talk with client
	private BufferedReader in;				// from client
	private PrintWriter out;				// to client
	private SketchServer server;			// handling communication for

	public SketchServerCommunicator(Socket sock, SketchServer server) {
		this.sock = sock;
		this.server = server;
	}

	/**
	 * Sends a message to the client
	 * @param msg
	 */
	public void send(String msg) {
		out.println(msg);
	}

	/**
	 * Keeps listening for and handling (your code) messages from the client
	 */
	public void run() {
		try {
			System.out.println("someone connected");

			// Communication channel
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(), true);

			for( int i: server.getSketch().getMap().navigableKeySet()){        // for the currently and newly created thread send all the shapes in the
																						// sketch to it
				send("DRAW" + " " + i + " " + server.getSketch().get(i).toString());
			}
			// Tell the client the current state of the world

            String line;
            while((line = in.readLine()) != null){   // while a message is being received from a client
                server.broadcast(line);              // broadcast the message to all the clients
                updateSketch.updatesSketch(line, server.getSketch());    // update the global sketch using the input from a client
            }

			// Keep getting and handling messages from the client

			// Clean up -- note that also remove self from server's list so it doesn't broadcast here
			server.removeCommunicator(this);
			out.close();
			in.close();
			sock.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
