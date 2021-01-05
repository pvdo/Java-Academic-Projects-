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
package application;
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Server.Server;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ClientFx extends Application {
	
	
	static Server server = new Server (5000);
	PrintWriter writer = null;
	
	TextArea messages = new TextArea();
	TextField type = new TextField();
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);

			
			ScrollPane messageBox = new ScrollPane();
			HBox typeBox = new HBox();
			
		    grid.setRowIndex(typeBox, 1);
		    grid.setColumnIndex(typeBox, 1);
			
			
			messageBox.setContent(messages);
			messages.setPrefSize(580, 300);
			messages.setEditable(false);
		    grid.setRowIndex(messageBox, 0);
		    grid.setColumnIndex(messageBox, 1);

			
			
			type.setPrefSize(500, 100);
			Button btnSend = new Button("Send");
			btnSend.setPrefSize(80, 100);
			
			typeBox.getChildren().addAll(type, btnSend);
			
			grid.getChildren().addAll(messageBox, typeBox);
			
			
			 
			Scene scene = new Scene(grid,700,500);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//SET UP SOCKET
		
		try{
			
			Socket socket = new Socket("localHost", 5000);
			
			messages.appendText("Connected. \n");
			
			this.writer = new PrintWriter(socket.getOutputStream(), true);
			
			//Allow to write and receive messages at the same time.
			//Read Message from Server.
			new Thread() {
				@Override
				public void run() {
					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						
						
						while(true) {
							String message = reader.readLine();
							messages.appendText(message);
						}
						
					}catch(IOException e){
						System.out.println("Impossible to read the message");
					}
					
				}
			}.start();
			
			
			
//			BufferedReader terminalReader = new BufferedReader(new InputStreamReader());
//			String terminalMessage = "";
//			while(true) {
//				terminalMessage = terminalReader.readLine();
//				if(terminalMessage == null || terminalMessage.length() == 0) {
//					continue;
//				}
//				writer.println(terminalMessage);
//				if(terminalMessage.equalsIgnoreCase("exit")) {
//					socket.close();
//					break;
//				}
//			}
				
		}catch (IOException e) {
			System.out.println("Client Exception " + e.getMessage());
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
    private class ButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
                //message

                String message = type.getText();

                //if message is empty, just return : don't send the message
                if (message.length() == 0) {
                    return;
                }

                //send message to server
                writer.write(message);

                //clear the textfield
                type.clear();

        }
    }
}
