package clientserver;

import java.io.*;
import java.net.*;
import java.util.Scanner;

// client accepts number from the user and send it to the server who will calculate value
// and return it to the client who will print it at the end 

public class Client {
	
	public static void main(String args[]) throws UnknownHostException, IOException{
		
		int number; // number that user enters 
		int temp; // number that is result and it is received from the server 
		
		Scanner scanner = new Scanner(System.in); // for accept input value from the user
		Socket socket = new Socket("127.0.0.1",1234); // 1-ip address of the machine where we want to connect; 2-port of the process which we want to communicate 
		Scanner scannerServer = new Scanner(socket.getInputStream()); // accept result from the server
		
		// getting number that user enters
		System.out.println("Enter some number: ");
		number = scanner.nextInt(); 
		
		// passing number that user enters to the socket (to the server exact)
		PrintStream stream = new PrintStream(socket.getOutputStream());
		stream.println(number);
		
		// accept result from the server
		temp = scannerServer.nextInt();
		System.out.println(temp);
		
	}
}
