package ClientManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Server.Server;

public class ClientManager extends Thread{
	
	private Socket socket;
	private String nameClient;
	private static final List<ClientManager> clients = new ArrayList<ClientManager>();
	private PrintWriter writer;
	private String receiveMessage;
	
	
	
	public ClientManager(Socket socket) {
		this.socket = socket;
		start();
	}
	
	public PrintWriter getWriter() {
		return this.writer;
	}
	
	public String receiveMessage(String message) {
		this.receiveMessage = message;
		return this.receiveMessage;
	}
	
	@Override
	public void run() {
		try{
			
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			this.writer = new PrintWriter(socket.getOutputStream(), true); //flush out automatically
			
			writer.println("Please type your name: ");
			String clientLine = input.readLine();
			this.nameClient = clientLine;
			writer.println("Hi" + this.nameClient);
			clients.add(this);
			
			
			while(true) {
				clientLine = input.readLine();
				
				if(clientLine.equals("exit")) {
						this.socket.close();
				}else {
					
					for(ClientManager client : clients) {
						client.getWriter().println(this.nameClient + ": " + clientLine);
					}
					
				}	
			}
		}catch(IOException e) {
			System.out.println("Server Exception" + e.getMessage());
		}finally {
			try {
				socket.close();
			}catch(IOException e) {}
		}
	
	}
}
