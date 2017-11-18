package clientserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class Server {

	public static void main(String args[]) throws IOException{
		
		int number, temp;
		
		ServerSocket serverSocket = new ServerSocket(1234); // specify port number
		System.out.println("Server is now running...");
		Socket socket = serverSocket.accept(); // it will accept incoming request to the serverSocket
		
		// to get number
		Scanner scanner = new Scanner(socket.getInputStream()); // to accept number that client wants to pass
		number = scanner.nextInt();
		
		// some code to manipulate with passed number
		temp = number*2;
		
		// to pass temp variable to the client and send it
		PrintStream stream = new PrintStream(socket.getOutputStream());
		stream.println(temp);
		
	}
}
