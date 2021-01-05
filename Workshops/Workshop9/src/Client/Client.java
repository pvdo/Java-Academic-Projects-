/**********************************************
Workshop 9
Course: JAC444 - 4th Semester
Last Name: Do Carmo Saraiva Teixeira
First Name: Pedro Vitor
ID: 100036193
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date: November 27, 2020
**********************************************/
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

import Server.Server;

public class Client {
	
	static Server server = new Server (5000);
	private static String sendMessage;
//	static PrintWriter writer;
	
//	public void sendMessage(String message) {
//		writer.write(message);
//	}

	public static void main(String [] args) {
		
		try{
			
			final Socket socket = new Socket("localHost", 5000);
			
			//Allow to write and receive messages at the same time.
			//Read Message from Server.
			new Thread() {
				@Override
				public void run() {
					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						
						
						while(true) {
							String message = reader.readLine();
							System.out.println(message);
						}
						
					}catch(IOException e){
						System.out.println("Impossible to read the message");
					}
					
				}
			}.start();
			
			
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
			String terminalMessage = "";
			while(true) {
				terminalMessage = terminalReader.readLine();
				if(terminalMessage == null || terminalMessage.length() == 0) {
					continue;
				}
				writer.println(terminalMessage);
				if(terminalMessage.equalsIgnoreCase("exit")) {
					break;
				}
			}
				
		}catch (IOException e) {
			System.out.println("Client Exception " + e.getMessage());
		}
	}
}
