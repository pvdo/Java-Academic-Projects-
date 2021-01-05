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
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ClientManager.ClientManager;

public class Server{
	
	private int serverPort;
	
	public Server(int serverPort) {
		this.serverPort = serverPort;
	}
	
	public static void main(String[] args) {
		
		ServerSocket ss = null;
		
		try{
			ss = new ServerSocket(5000);
			
			System.out.println("Server started at " + new Date() + "\n");
			
			while(true) {
		
				Socket clientSocket = ss.accept();
				new ClientManager(clientSocket);
			
				System.out.println("Client connected");
			
			}
		}catch(IOException e) {
			System.out.println("Server Exception " + e.getMessage());
			try {
				if(ss != null) {
					ss.close();
				}
			}catch (IOException er) {
				er.printStackTrace();
			}
		}
	}
	
//	public List<OpenThread> getClients() {
//		return connectionList;
//	}
	
//	public void broadcast(String message) {
//		clientConnection.getMessage();
//        for (OpenThread clientConnection : this.connectionList) {
//            
//        }
//    }

}
