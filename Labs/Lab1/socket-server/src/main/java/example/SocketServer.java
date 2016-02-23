package example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) throws IOException {
		// Check arguments
		if (args.length < 1) {
			System.err.println("Argument(s) missing!");
			System.err.printf("Usage: java %s port%n", SocketServer.class.getName());
			return;
		}

		// Convert port from String to int
		int port = Integer.parseInt(args[0]);

		// Create server socket
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.printf("Server accepting connections on port %d %n", port);

		// wait for and then accept client connection
		// a socket is created to handle the created connection
		Socket clientSocket = serverSocket.accept();
		System.out.printf("Connected to client %s on port %d %n", clientSocket.getInetAddress().getHostAddress(),
				clientSocket.getPort());

		// Create stream to receive data from client
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		// Receive data until client closes the connection
		String response;
		while ((response = in.readLine()) != null)
		{
			System.out.printf("Received message with content: '%s'%n", response);
		DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
		

		// Send text to server as bytes
		out.writeBytes("I recieved stuffs!");
		out.writeBytes("\n");
		}

		// Close connection to current client
		clientSocket.close();
		System.out.println("Closed connection with client");

		// Close server socket
		serverSocket.close();
		System.out.println("Closed server socket");
	}
}
